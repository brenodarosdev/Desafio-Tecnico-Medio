package com.restaurante.deliverysystem.pedido.application.service;

import com.restaurante.deliverysystem.pedido.application.api.PedidoCriadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoDetalhadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;

import java.util.UUID;

public interface PedidoService {
    PedidoCriadoResponse criaNovoPedido(PedidoRequest pedidoRequest, UUID idCliente);
    PedidoDetalhadoResponse buscaPedidoPorId(UUID idPedido);
    void alteraPedido(PedidoRequest alteraPedidoRequest, UUID idPedido);
}
