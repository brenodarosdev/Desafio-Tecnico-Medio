package com.restaurante.deliverysystem.entrega.application.service;

import com.restaurante.deliverysystem.entrega.application.api.EntregaConcluidaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaDetalhadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;

import java.util.UUID;

public interface EntregaService {
    EntregaCriadaResponse criaNovaEntrega(EntregaRequest entregaNovoRequest, UUID idPedido, String emailCliente);
    EntregaDetalhadaResponse buscaEntregaPorId(UUID idEntrega, String emailCliente);
    void alteraEntrega(EntregaRequest entregaAlteraRequest, UUID idEntrega, String emailCliente);
    void alteraStatusParaACaminho(UUID idEntrega, String emailCliente);
    EntregaConcluidaResponse alteraStatusParaEntregue(UUID idEntrega, String emailCliente);
    void deletaEntrega(UUID idEntrega, String emailCliente);
}
