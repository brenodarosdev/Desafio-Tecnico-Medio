package com.restaurante.deliverysystem.cliente.application.api;

import jakarta.validation.constraints.*;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

@Value
public class CienteRequest {
    @Indexed(unique = true)
    @NotBlank(message = "O campo email não pode estar em branco")
    @Email(message = "Este campo deve conter um email")
    private String email;
    @Size(min = 6, max = 60, message = "A senha deve ter de 6 a 60 caracteres")
    @NotBlank(message = "O campo senha não pode estar em branco")
    private String senha;
    @NotBlank(message = "O campo nomeCompleto não pode estar em branco")
    private String nomeCompleto;
    @NotNull(message = "O campo idade não pode ser nulo")
    @Min(value = 18, message = "A idade deve ser igual ou maior que 18")
    private int idade;
}
