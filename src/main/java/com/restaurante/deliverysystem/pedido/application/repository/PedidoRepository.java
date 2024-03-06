package com.restaurante.deliverysystem.pedido.application.repository;

import com.restaurante.deliverysystem.pedido.domain.Pedido;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
}
