package com.restaurante.deliverysystem.pedido.application.repository;

import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class PedidoInfraRepository implements PedidoRepository {
    @Override
    public Pedido salva(Pedido pedido) {
        log.info("[inicia] PedidoInfraRepository - salva");
        log.info("[finaliza] PedidoInfraRepository - salva");
        return null;
    }
}
