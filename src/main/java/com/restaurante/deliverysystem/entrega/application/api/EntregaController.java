package com.restaurante.deliverysystem.entrega.application.api;

import com.restaurante.deliverysystem.entrega.application.service.EntregaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class EntregaController implements EntregaAPI {
    private final EntregaService entregaService;

    @Override
    public EntregaCriadaResponse postCriaNovaEntrega(EntregaRequest entregaNovoRequest, UUID idPedido) {
        log.info("[inicia] EntregaController - postCriaNovaEntrega");
        EntregaCriadaResponse entregaCriadaResponse = entregaService.criaNovaEntrega(entregaNovoRequest, idPedido);
        log.info("[finaliza] EntregaController - postCriaNovaEntrega");
        return entregaCriadaResponse;
    }
}
