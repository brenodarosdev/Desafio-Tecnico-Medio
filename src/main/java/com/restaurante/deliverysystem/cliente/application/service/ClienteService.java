package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.ClienteRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteDetalhadoResponse;

import java.util.UUID;

public interface ClienteService {
    ClienteCriadoResponse cadastraNovoCliente(ClienteRequest clienteNovoRequest);
    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente, String emailCliente);
    void alteraCliente(ClienteRequest alteraClienteRequest, UUID idCliente, String emailCliente);
    void deletaCliente(UUID idCliente, String emailCliente);
}
