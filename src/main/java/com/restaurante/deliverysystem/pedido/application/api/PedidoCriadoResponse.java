package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.Value;

import java.util.UUID;

@Value
public class PedidoCriadoResponse {
    private UUID idPedido;

    public PedidoCriadoResponse(Pedido pedido) {
        this.idPedido = pedido.getIdPedido();
    }
}
