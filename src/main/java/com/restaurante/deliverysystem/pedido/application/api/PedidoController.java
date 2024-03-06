package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.pedido.application.service.PedidoService;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class PedidoController implements PedidoAPI {
    private final PedidoService pedidoService;

    @Override
    public PedidoCriadoResponse postCriaNovoPedido(PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoController - postCriaNovoPedido");
        PedidoCriadoResponse pedidoCriadoResponse = pedidoService.criaNovoPedido(pedidoRequest);
        log.info("[finaliza] PedidoController - postCriaNovoPedido");
        return null;
    }
}
