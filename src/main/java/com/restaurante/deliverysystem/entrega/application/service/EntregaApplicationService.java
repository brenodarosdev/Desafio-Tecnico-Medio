package com.restaurante.deliverysystem.entrega.application.service;

import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import com.restaurante.deliverysystem.entrega.application.api.EntregaConcluidaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaDetalhadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;
import com.restaurante.deliverysystem.entrega.application.repository.EntregaRepository;
import com.restaurante.deliverysystem.entrega.domain.Entrega;
import com.restaurante.deliverysystem.pedido.application.repository.PedidoRepository;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Log4j2
public class EntregaApplicationService implements EntregaService {
    private final EntregaRepository entregaRepository;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public EntregaCriadaResponse criaNovaEntrega(EntregaRequest entregaNovoRequest, UUID idPedido, String emailCliente) {
        log.info("[inicia] EntregaApplicationService - criaNovaEntrega");
        UUID idCliente = pedidoRepository.pedidoPorId(idPedido).getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        Entrega entrega = entregaRepository.salva(new Entrega(entregaNovoRequest, idPedido));
        log.info("[finaliza] EntregaApplicationService - criaNovaEntrega");
        return new EntregaCriadaResponse(entrega);
    }

    @Override
    public EntregaDetalhadaResponse buscaEntregaPorId(UUID idEntrega, String emailCliente) {
        log.info("[inicia] EntregaApplicationService - buscaEntregaPorId");
        Entrega entrega = entregaRepository.entregaPorId(idEntrega);
        UUID idPedido = entrega.getIdPedido();
        UUID idCliente = pedidoRepository.pedidoPorId(idPedido).getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        log.info("[finaliza] EntregaApplicationService - buscaEntregaPorId");
        return new EntregaDetalhadaResponse(entrega);
    }

    @Override
    public void alteraEntrega(EntregaRequest entregaAlteraRequest, UUID idEntrega, String emailCliente) {
        log.info("[inicia] EntregaApplicationService - alteraEntrega");
        Entrega entrega = entregaRepository.entregaPorId(idEntrega);
        UUID idPedido = entrega.getIdPedido();
        UUID idCliente = pedidoRepository.pedidoPorId(idPedido).getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        entrega.alteraEntrega(entregaAlteraRequest);
        entregaRepository.salva(entrega);
        log.info("[finaliza] EntregaApplicationService - alteraEntrega");
    }

    @Override
    public void alteraStatusParaACaminho(UUID idEntrega, String emailCliente) {
        log.info("[inicia] EntregaApplicationService - alteraStatusParaACaminho");
        Entrega entrega = entregaRepository.entregaPorId(idEntrega);
        UUID idPedido = entrega.getIdPedido();
        UUID idCliente = pedidoRepository.pedidoPorId(idPedido).getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        entrega.alteraStatusParaACaminho();
        entregaRepository.salva(entrega);
        log.info("[finaliza] EntregaApplicationService - alteraStatusParaACaminho");
    }

    @Override
    public EntregaConcluidaResponse alteraStatusParaEntregue(UUID idEntrega, String  emailCliente) {
        log.info("[inicia] EntregaApplicationService - alteraStatusParaEntregue");
        Entrega entrega = entregaRepository.entregaPorId(idEntrega);
        UUID idPedido = entrega.getIdPedido();
        UUID idCliente = pedidoRepository.pedidoPorId(idPedido).getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        entrega.alteraStatusParaEntregue();
        entregaRepository.salva(entrega);
        log.info("[finaliza] EntregaApplicationService - alteraStatusParaEntregue");
        return new EntregaConcluidaResponse(entrega);
    }

    @Override
    public void deletaEntrega(UUID idEntrega, String emailCliente) {
        log.info("[inicia] EntregaApplicationService - deletaEntrega");
        Entrega entrega = entregaRepository.entregaPorId(idEntrega);
        UUID idPedido = entrega.getIdPedido();
        UUID idCliente = pedidoRepository.pedidoPorId(idPedido).getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        entregaRepository.deletaEntregaPorId(idEntrega);
        log.info("[finaliza] EntregaApplicationService - deletaEntrega");
    }
}
