package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.pedido.application.service.PedidoService;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class PedidoController implements PedidoAPI {
    private final PedidoService pedidoService;

    @Override
    public PedidoCriadoResponse postCriaNovoPedido(PedidoRequest pedidoRequest, UUID idCliente) {
        log.info("[inicia] PedidoController - postCriaNovoPedido");
        PedidoCriadoResponse pedidoCriadoResponse = pedidoService.criaNovoPedido(pedidoRequest, idCliente);
        log.info("[finaliza] PedidoController - postCriaNovoPedido");
        return pedidoCriadoResponse;
    }

    @Override
    public PedidoDetalhadoResponse getBuscaPedidoPorId(UUID idPedido) {
        log.info("[inicia] PedidoController - getBuscaPedidoPorId");
        PedidoDetalhadoResponse pedidoDetalhadoResponse = pedidoService.buscaPedidoPorId(idPedido);
        log.info("[finaliza] PedidoController - getBuscaPedidoPorId");
        return pedidoDetalhadoResponse;
    }

    @Override
    public void patchAlteraPedido(PedidoRequest alteraPedidoRequest, UUID idPedido) {
        log.info("[inicia] PedidoController - patchAlteraPedido");
        log.info("[finaliza PedidoController - patchAlteraPedido");
    }
}
