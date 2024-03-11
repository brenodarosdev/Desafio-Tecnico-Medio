package com.restaurante.deliverysystem.cliente.application.api;

import jakarta.validation.constraints.*;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

@Value
public class CienteRequest {
    @Indexed(unique = true)
    @NotBlank
    @Email
    private String email;
    @Size(min = 6, max = 60)
    @NotBlank
    private String senha;
    @NotBlank
    private String nomeCompleto;
    @NotNull
    @Min(18)
    private int idade;
}
