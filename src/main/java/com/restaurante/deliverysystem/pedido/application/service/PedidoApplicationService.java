package com.restaurante.deliverysystem.pedido.application.service;

import com.restaurante.deliverysystem.pedido.application.api.PedidoCriadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PedidoApplicationService implements PedidoService {
    @Override
    public PedidoCriadoResponse criaNovoPedido(PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoApplicationService - criaNovoPedido");
        log.info("[finaliza] PedidoApplicationService - criaNovoPedido");
        return null;
    }
}
