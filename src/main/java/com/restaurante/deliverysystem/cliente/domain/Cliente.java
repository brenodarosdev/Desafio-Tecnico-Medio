package com.restaurante.deliverysystem.cliente.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Cliente")
public class Cliente {
    @Id
    private UUID idCliente;
    @Email
    @Indexed(unique = true)
    private String email;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Size(min = 18)
    private int idade;

    public Cliente(UUID idCliente, String email, String nomeCompleto, int idade) {
        this.idCliente = idCliente;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
    }
}
