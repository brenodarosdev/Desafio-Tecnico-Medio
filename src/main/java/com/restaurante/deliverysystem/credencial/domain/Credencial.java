package com.restaurante.deliverysystem.credencial.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Credencial")
public class Credencial implements UserDetails {
    @MongoId(targetType = FieldType.STRING)
    @Getter
    private String email;
    @NotBlank
    @Size(min = 6, max = 60)
    private String senha;
    @Getter
    private boolean validado;

    public Credencial(String email, String senha) {
        this.email = email;
        var encriptador = new BCryptPasswordEncoder();
        this.senha = encriptador.encode(senha);
        this.validado = true;
    }

    public void encriptaSenha() {
        var encriptador = new BCryptPasswordEncoder();
        this.senha = encriptador.encode(this.senha);
    }

    public void validaCredencial() {
        this.validado = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
