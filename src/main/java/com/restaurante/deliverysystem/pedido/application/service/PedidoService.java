package com.restaurante.deliverysystem.pedido.application.service;

import com.restaurante.deliverysystem.pedido.application.api.PedidoCriadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoDetalhadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    PedidoCriadoResponse criaNovoPedido(PedidoRequest pedidoRequest, UUID idCliente, String emailCliente);
    PedidoDetalhadoResponse buscaPedidoPorId(UUID idPedido, String emailCliente);
    List<PedidoDetalhadoResponse> listaTodosPedidosPorIdCliente(UUID idCliente, String emailCliente);
    void alteraPedido(PedidoRequest alteraPedidoRequest, UUID idPedido, String emailCliente);
    void deletaPedido(UUID idPedido);
}
