package com.restaurante.deliverysystem.entrega.application.api;

import com.restaurante.deliverysystem.entrega.domain.Entrega;
import lombok.Value;

import java.util.UUID;

@Value
public class EntregaCriadaResponse {
    private UUID idEntrega;

    public EntregaCriadaResponse(Entrega entrega) {
        this.idEntrega = entrega.getIdEntrega();
    }
}
