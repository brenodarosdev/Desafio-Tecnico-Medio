package com.restaurante.deliverysystem.credencial.application.service;

import com.restaurante.deliverysystem.cliente.application.api.ClienteRequest;
import com.restaurante.deliverysystem.credencial.domain.Credencial;

public interface CredencialService {
    void criaNovaCredencial(ClienteRequest clienteNovoRequest);
    Credencial buscaCredencialPorEmail(String email);
}
