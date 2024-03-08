package com.restaurante.deliverysystem.entrega.application.service;

import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;
import com.restaurante.deliverysystem.entrega.application.repository.EntregaRepository;
import com.restaurante.deliverysystem.entrega.domain.Entrega;
import com.restaurante.deliverysystem.pedido.application.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Log4j2
public class EntregaApplicationService implements EntregaService {
    private final EntregaRepository entregaRepository;

    @Override
    public EntregaCriadaResponse criaNovaEntrega(EntregaRequest entregaNovoRequest, UUID idPedido) {
        log.info("[inicia] EntregaApplicationService - criaNovaEntrega");
        Entrega entrega = entregaRepository.salva(new Entrega(entregaNovoRequest, idPedido));
        log.info("[finaliza] EntregaApplicationService - criaNovaEntrega");
        return new EntregaCriadaResponse(entrega);
    }
}