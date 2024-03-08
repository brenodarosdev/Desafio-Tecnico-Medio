package com.restaurante.deliverysystem.entrega.application.repository;

import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaDetalhadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;
import com.restaurante.deliverysystem.entrega.domain.Entrega;

import java.util.UUID;

public interface EntregaRepository {
    Entrega salva(Entrega entrega);
    EntregaDetalhadaResponse entregaPorId(UUID idEntrega);
}
