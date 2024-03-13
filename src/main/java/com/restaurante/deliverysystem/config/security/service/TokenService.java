package com.restaurante.deliverysystem.config.security.service;

import com.restaurante.deliverysystem.credencial.domain.Credencial;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
@Log4j2
public class TokenService {
    @Value("${restaurante.jwt.expiracao}")
    private String expiracao;
    @Value("${restaurante.jwt.chave}")
    private String chave;

    public String geraToken(Authentication authentication) {
        return geraToken((Credencial) authentication.getPrincipal());
    }

    public String geraToken(Credencial credencial) {
        log.info("[inicia] TokenService - geraToken");
        String token = Jwts.builder()
                .setIssuer("API de Restaurante")
                .setSubject(credencial.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now()
                        .plusMinutes(Long.parseLong(expiracao))
                        .atZone(ZoneId.systemDefault())
                        .toInstant()))
                .signWith(SignatureAlgorithm.HS256, chave)
                .compact();
        log.info("[finaliza] TokenService - geraToken");
		return token;
    }

    public Optional<String> getEmail(String token) {
        try {
            log.info("[inicia] TokenService - extração do ID do Token");
            var claims = Jwts.parser().setSigningKey(chave).parseClaimsJws(token).getBody();
            log.info("[finaliza] TokenService - extração do ID do Token");
            return Optional.of(claims.getSubject());
        } catch (SignatureException ex) {
            return Optional.empty();
        } catch (ExpiredJwtException ex) {
            var claims = ex.getClaims();
            log.info("[finaliza] TokenService - extração do ID do Token");
            return Optional.of(claims.getSubject());
        }
    }

    public Optional<String> getEmailByBearerToken(String bearerToken) {
        log.info("[inicia] TokenService - getEmailByBearerToken");
        String token = bearerToken.substring(7);
        log.info(token);
        log.info("[finaliza] TokenService - getEmailByBearerToken");
        return this.getEmail(token);
    }
}
