package com.restaurante.deliverysystem.cliente.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

@Value
public class CienteNovoRequest {
    @Email
    @Indexed(unique = true)
    private String email;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Size(min = 18)
    private int idade;
}
