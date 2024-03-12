package com.restaurante.deliverysystem.config.security;


import com.restaurante.deliverysystem.config.security.service.AutenticacaoSecurityService;
import com.restaurante.deliverysystem.config.security.service.TokenService;
import com.restaurante.deliverysystem.credencial.application.service.CredencialService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenService tokenService;
    private final CredencialService credencialService;
    private final AutenticacaoSecurityService autenticacaoSecurityService;
    private final AuthenticationConfiguration configuration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoSecurityService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/public/**").permitAll()
                    .anyRequest().authenticated())
                    .csrf(AbstractHttpConfigurer::disable)
                    .sessionManagement((sessions) -> sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .addFilterBefore(new FiltroToken(tokenService, credencialService),
                            UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
        return (web) -> web.ignoring().requestMatchers("/**.html", "/v3/api-docs/**",
                "/webjars/**", "/configuration/**", "/swagger-ui/**", "/swagger-ui.html");
    }
}
