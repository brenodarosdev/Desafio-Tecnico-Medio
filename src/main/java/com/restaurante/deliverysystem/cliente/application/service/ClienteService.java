package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteDetalhadoResponse;

import java.util.UUID;

public interface ClienteService {
    ClienteCriadoResponse cadastraNovoCliente(CienteRequest clienteNovoRequest);
    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);
    void alteraCliente(CienteRequest alteraClienteRequest, UUID idCliente);
}
