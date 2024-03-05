package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteNovoRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;

public interface ClienteService {
    ClienteCriadoResponse cadastraNovoCliente(CienteNovoRequest clienteNovoRequest);
}
