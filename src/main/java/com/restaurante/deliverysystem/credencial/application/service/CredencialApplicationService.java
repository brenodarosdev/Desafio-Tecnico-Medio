package com.restaurante.deliverysystem.credencial.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CredencialApplicationService implements CredencialService {
    @Override
    public void criaNovaCredencial(CienteRequest clienteNovoRequest) {
        log.info("[inicia] CredencialApplicationService - criaNovaCredencial");
        log.info("[finaliza] CredencialApplicationService - criaNovaCredencial");
    }
}
