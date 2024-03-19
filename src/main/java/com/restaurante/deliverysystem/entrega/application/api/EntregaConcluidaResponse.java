package com.restaurante.deliverysystem.entrega.application.api;

import com.restaurante.deliverysystem.entrega.domain.Entrega;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class EntregaConcluidaResponse {
    private LocalDateTime dataHoraDaEntrega;

    public EntregaConcluidaResponse(Entrega entrega) {
        this.dataHoraDaEntrega = entrega.getDataHoraDaEntrega();
    }
}
