package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteDetalhadoResponse;

import java.util.UUID;

public interface ClienteService {
    ClienteCriadoResponse cadastraNovoCliente(CienteRequest clienteNovoRequest);
    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente, String emailCliente);
    void alteraCliente(CienteRequest alteraClienteRequest, UUID idCliente, String emailCliente);
    void deletaCliente(UUID idCliente, String emailCliente);
}
