package com.restaurante.deliverysystem.pedido.application.service;

import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.pedido.application.api.PedidoCriadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoDetalhadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;
import com.restaurante.deliverysystem.pedido.application.repository.PedidoRepository;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Log4j2
public class PedidoApplicationService implements PedidoService {
    private final PedidoRepository pedidoRepository;

    @Override
    public PedidoCriadoResponse criaNovoPedido(PedidoRequest pedidoRequest, UUID idCliente) {
        log.info("[inicia] PedidoApplicationService - criaNovoPedido");
        Pedido pedido = pedidoRepository.salva(new Pedido(pedidoRequest, idCliente));
        log.info("[finaliza] PedidoApplicationService - criaNovoPedido");
        return new PedidoCriadoResponse(pedido);
    }

    @Override
    public PedidoDetalhadoResponse buscaPedidoPorId(UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - buscaPedidoPorId");
        Pedido pedido = pedidoRepository.pedidoPorId(idPedido);
        log.info("[finaliza] PedidoApplicationService - buscaPedidoPorId");
        return new PedidoDetalhadoResponse(pedido);
    }

    @Override
    public void alteraPedido(PedidoRequest alteraPedidoRequest, UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - alteraPedido");
        Pedido pedido = pedidoRepository.pedidoPorId(idPedido);
        pedido.alteraPedido(alteraPedidoRequest);
        pedidoRepository.salva(pedido);
        log.info("[finaliza] PedidoApplicationService - alteraPedido");
    }
}
