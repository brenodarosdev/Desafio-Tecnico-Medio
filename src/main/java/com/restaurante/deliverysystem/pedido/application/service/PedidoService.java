package com.restaurante.deliverysystem.pedido.application.service;

import com.restaurante.deliverysystem.pedido.application.api.PedidoCriadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;

public interface PedidoService {
    PedidoCriadoResponse criaNovoPedido(PedidoRequest pedidoRequest);
}
