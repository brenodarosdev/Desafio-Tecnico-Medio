package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteNovoRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteDetalhadoResponse;

import java.util.UUID;

public interface ClienteService {
    ClienteCriadoResponse cadastraNovoCliente(CienteNovoRequest clienteNovoRequest);
    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);
}
