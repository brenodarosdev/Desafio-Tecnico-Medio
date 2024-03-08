package com.restaurante.deliverysystem.entrega.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class EntregaController implements EntregaAPI {
    @Override
    public EntregaCriadaResponse postCriaNovaEntrega(EntregaRequest entregaNovoRequest) {
        log.info("[inicia] EntregaController - postCriaNovaEntrega");
        log.info("[finaliza] EntregaController - postCriaNovaEntrega");
        return null;
    }
}
