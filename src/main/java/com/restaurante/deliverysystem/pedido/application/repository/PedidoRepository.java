package com.restaurante.deliverysystem.pedido.application.repository;

import com.restaurante.deliverysystem.pedido.domain.Pedido;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
    Pedido pedidoPorId(UUID idPedido);
    List<Pedido> pedidosPorIdCliente(UUID idCliente);
    void deletaPedidoPorId(UUID idPedido);
}
