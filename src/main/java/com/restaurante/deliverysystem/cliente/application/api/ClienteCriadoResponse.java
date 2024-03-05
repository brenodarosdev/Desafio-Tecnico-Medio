package com.restaurante.deliverysystem.cliente.application.api;

import com.restaurante.deliverysystem.cliente.domain.Cliente;
import lombok.Value;

import java.util.UUID;

@Value
public class ClienteCriadoResponse {
    private UUID idCliente;

    public ClienteCriadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
    }
}
