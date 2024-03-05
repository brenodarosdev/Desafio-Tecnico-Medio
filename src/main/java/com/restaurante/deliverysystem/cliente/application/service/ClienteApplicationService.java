package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteNovoRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClienteApplicationService implements ClienteService {
    @Override
    public ClienteCriadoResponse cadastraNovoCliente(CienteNovoRequest clienteNovoRequest) {
        log.info("[inicia] ClienteApplicationService - cadastraNovoCliente");
        log.info("[finaliza] ClienteApplicationService - cadastraNovoCliente");
        return null;
    }
}
