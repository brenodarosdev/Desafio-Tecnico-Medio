package com.restaurante.deliverysystem.credencial.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import com.restaurante.deliverysystem.credencial.domain.Credencial;
import jakarta.validation.Valid;
import lombok.Value;

public interface CredencialService {
    void criaNovaCredencial(@Valid CienteRequest clienteNovoRequest);
}
