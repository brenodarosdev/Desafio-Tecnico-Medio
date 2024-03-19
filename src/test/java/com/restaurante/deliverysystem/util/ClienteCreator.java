package com.restaurante.deliverysystem.util;

import com.restaurante.deliverysystem.cliente.domain.Cliente;
import com.restaurante.deliverysystem.cliente.application.api.ClienteRequest;

import java.util.UUID;

public class ClienteCreator {
    private static final UUID idCliente1 = UUID.fromString("3deb33b6-8a91-41d4-8afb-72f75cfd7780");

    public static ClienteRequest criaClienteRequest() {
        return new ClienteRequest("email@email.com", "123456", "Ireneu da Silva", 19);
    }

    public static Cliente criaCliente() {
        return new Cliente(criaClienteRequest());
    }
}
