package com.restaurante.deliverysystem.cliente.application.repository;

import com.restaurante.deliverysystem.cliente.domain.Cliente;

import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    Cliente clientePorId(UUID idCliente);
}
