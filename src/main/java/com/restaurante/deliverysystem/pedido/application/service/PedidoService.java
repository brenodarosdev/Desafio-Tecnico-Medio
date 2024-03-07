package com.restaurante.deliverysystem.pedido.application.service;

import com.restaurante.deliverysystem.pedido.application.api.PedidoCriadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoDetalhadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    PedidoCriadoResponse criaNovoPedido(PedidoRequest pedidoRequest, UUID idCliente);
    PedidoDetalhadoResponse buscaPedidoPorId(UUID idPedido);
    List<PedidoDetalhadoResponse> listaTodosPedidosPorIdCliente(UUID idCliente);
    void alteraPedido(PedidoRequest alteraPedidoRequest, UUID idPedido);
    void deletaPedido(UUID idPedido);
}