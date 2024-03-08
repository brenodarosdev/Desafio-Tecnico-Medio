package com.restaurante.deliverysystem.entrega.application.service;

import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;

public interface EntregaService {
    EntregaCriadaResponse criaNovaEntrega(EntregaRequest entregaNovoRequest);
}
