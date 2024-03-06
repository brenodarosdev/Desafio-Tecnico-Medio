package com.restaurante.deliverysystem.cliente.application.api;

import com.restaurante.deliverysystem.cliente.domain.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

@Value
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String email;
    private String nomeCompleto;
    private int idade;

    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.email = cliente.getEmail();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.idade = cliente.getIdade();
    }
}
