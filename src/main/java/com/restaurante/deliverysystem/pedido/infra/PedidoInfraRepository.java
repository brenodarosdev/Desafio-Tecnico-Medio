package com.restaurante.deliverysystem.pedido.infra;

import com.restaurante.deliverysystem.pedido.application.repository.PedidoRepository;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import com.restaurante.deliverysystem.pedido.infra.PedidoSpringDataMongoDBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

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
}
