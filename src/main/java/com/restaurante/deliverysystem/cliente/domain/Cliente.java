package com.restaurante.deliverysystem.cliente.domain;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import com.restaurante.deliverysystem.handler.APIException;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

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

    public void alteraCliente(CienteRequest alteraClienteRequest) {
        this.email = alteraClienteRequest.getEmail();
        this.nomeCompleto = alteraClienteRequest.getNomeCompleto();
        this.idade = alteraClienteRequest.getIdade();
    }

    public void validaCliente(UUID idCliente) {
        if(!this.idCliente.equals(idCliente)) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Credencial de autenticação não é válida!");
        }
    }
}
