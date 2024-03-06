package com.restaurante.deliverysystem.cliente.domain;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import jakarta.validation.constraints.*;
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
    @Indexed(unique = true)
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nomeCompleto;
    @NotNull
    @Min(18)
    private int idade;

    public Cliente(CienteRequest clienteNovoRequest) {
        this.idCliente = UUID.randomUUID();
        this.email = clienteNovoRequest.getEmail();
        this.nomeCompleto = clienteNovoRequest.getNomeCompleto();
        this.idade = clienteNovoRequest.getIdade();
    }
}
