package com.restaurante.deliverysystem.entrega.application.service;

import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EntregaApplicationService implements EntregaService {
    @Override
    public EntregaCriadaResponse criaNovaEntrega(EntregaRequest entregaNovoRequest) {
        log.info("[inicia] EntregaApplicationService - criaNovaEntrega");
        log.info("[finaliza] EntregaApplicationService - criaNovaEntrega");
        return null;
    }
}
