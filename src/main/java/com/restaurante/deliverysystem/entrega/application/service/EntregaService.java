package com.restaurante.deliverysystem.entrega.application.service;

import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;

import java.util.UUID;

public interface EntregaService {
    EntregaCriadaResponse criaNovaEntrega(EntregaRequest entregaNovoRequest, UUID idPedido);
}
