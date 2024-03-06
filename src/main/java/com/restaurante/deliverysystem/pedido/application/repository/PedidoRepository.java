package com.restaurante.deliverysystem.pedido.application.repository;

import com.restaurante.deliverysystem.pedido.domain.Pedido;

import java.util.UUID;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
    Pedido pedidoPorId(UUID idPedido);
}
