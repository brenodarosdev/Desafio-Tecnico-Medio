package com.restaurante.deliverysystem.pedido.application.service;

import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import com.restaurante.deliverysystem.credencial.application.service.CredencialService;
import com.restaurante.deliverysystem.pedido.application.api.PedidoCriadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoDetalhadoResponse;
import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;
import com.restaurante.deliverysystem.pedido.application.repository.PedidoRepository;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.swing.event.ListDataEvent;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Log4j2
public class PedidoApplicationService implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final CredencialService credencialService;

    @Override
    public PedidoCriadoResponse criaNovoPedido(PedidoRequest pedidoRequest, UUID idCliente, String emailCliente) {
        log.info("[inicia] PedidoApplicationService - criaNovoPedido");
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        Pedido pedido = pedidoRepository.salva(new Pedido(pedidoRequest, idCliente));
        log.info("[finaliza] PedidoApplicationService - criaNovoPedido");
        return new PedidoCriadoResponse(pedido);
    }

    @Override
    public PedidoDetalhadoResponse buscaPedidoPorId(UUID idPedido, String emailCliente) {
        log.info("[inicia] PedidoApplicationService - buscaPedidoPorId");
        Pedido pedido = pedidoRepository.pedidoPorId(idPedido);
        UUID idCliente = pedido.getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("[finaliza] PedidoApplicationService - buscaPedidoPorId");
        return new PedidoDetalhadoResponse(pedido);
    }

    @Override
    public List<PedidoDetalhadoResponse> listaTodosPedidosPorIdCliente(UUID idCliente, String emailCliente) {
        log.info("[inicia] PedidoApplicationService - listaTodosPedidosPorIdCliente");
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        List<Pedido> pedidos = pedidoRepository.pedidosPorIdCliente(idCliente);
        log.info("[finaliza] PedidoApplicationService - listaTodosPedidosPorIdCliente");
        return PedidoDetalhadoResponse.converte(pedidos);
    }

    @Override
    public void alteraPedido(PedidoRequest alteraPedidoRequest, UUID idPedido, String emailCliente) {
        log.info("[inicia] PedidoApplicationService - alteraPedido");
        Pedido pedido = pedidoRepository.pedidoPorId(idPedido);
        UUID idCliente = pedido.getIdCliente();
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        pedido.alteraPedido(alteraPedidoRequest);
        pedidoRepository.salva(pedido);
        log.info("[finaliza] PedidoApplicationService - alteraPedido");
    }

    @Override
    public void deletaPedido(UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - deletaPedido");
        pedidoRepository.pedidoPorId(idPedido);
        pedidoRepository.deletaPedidoPorId(idPedido);
        log.info("[finaliza] PedidoApplicationService - deletaPedido");
    }
}
