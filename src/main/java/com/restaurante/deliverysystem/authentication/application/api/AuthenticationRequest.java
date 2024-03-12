package com.restaurante.deliverysystem.authentication.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Value
public class AuthenticationRequest {
    @NotBlank(message = "O email não pode estar em branco!")
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres", max = 60)
    private String senha;

    public UsernamePasswordAuthenticationToken getUserPassToken() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
