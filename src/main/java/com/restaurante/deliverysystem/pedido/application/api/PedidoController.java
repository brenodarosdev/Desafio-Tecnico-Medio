package com.restaurante.deliverysystem.pedido.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PedidoController implements PedidoAPI {
    @Override
    public PedidoCriadoResponse postCriaNovoPedido(PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoController - postCriaNovoPedido");
        log.info("[finaliza] PedidoController - postCriaNovoPedido");
        return null;
    }
}
