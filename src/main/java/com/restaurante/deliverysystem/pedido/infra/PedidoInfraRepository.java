package com.restaurante.deliverysystem.pedido.infra;

import com.restaurante.deliverysystem.handler.APIException;
import com.restaurante.deliverysystem.pedido.application.repository.PedidoRepository;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import com.restaurante.deliverysystem.pedido.infra.PedidoSpringDataMongoDBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
@Log4j2
public class PedidoInfraRepository implements PedidoRepository {
    private final PedidoSpringDataMongoDBRepository pedidoSpringDataMongoDBRepository;

    @Override
    public Pedido salva(Pedido pedido) {
        log.info("[inicia] PedidoInfraRepository - salva");
        Pedido pedidoSalvo = pedidoSpringDataMongoDBRepository.save(pedido);
        log.info("[finaliza] PedidoInfraRepository - salva");
        return pedidoSalvo;
    }

    @Override
    public Pedido pedidoPorId(UUID idPedido) {
        log.info("[inicia] PedidoInfraRepository - pedidoPorId");
        Pedido pedido = pedidoSpringDataMongoDBRepository.findByIdPedido(idPedido)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Pedido não encontrado!"));
        log.info("[finaliza] PedidoInfraRepository - pedidoPorId");
        return pedido;
    }

    @Override
    public List<Pedido> pedidosPorIdCliente(UUID idCliente) {
        log.info("[inicia] PedidoInfraRepository - pedidosPorIdCliente");
        List<Pedido> pedidosDoCliente = pedidoSpringDataMongoDBRepository.findAllByIdCliente(idCliente);
        log.info("[finaliza] PedidoInfraRepository - pedidosPorIdCliente");
        return pedidosDoCliente;
    }

    @Override
    public void deletaPedidoPorId(UUID idPedido) {
        log.info("[inicia] PedidoInfraRepository - deletaPedidoPorId");
        pedidoSpringDataMongoDBRepository.deleteByIdPedido(idPedido);
        log.info("[finaliza] PedidoInfraRepository - deletaPedidoPorId");
    }
}
