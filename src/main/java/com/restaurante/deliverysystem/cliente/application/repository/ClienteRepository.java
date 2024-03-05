package com.restaurante.deliverysystem.cliente.application.repository;

import com.restaurante.deliverysystem.cliente.domain.Cliente;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
}
