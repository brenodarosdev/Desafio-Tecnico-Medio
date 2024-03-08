package com.restaurante.deliverysystem.entrega.infra;

import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;
import com.restaurante.deliverysystem.entrega.application.repository.EntregaRepository;
import com.restaurante.deliverysystem.entrega.domain.Entrega;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
@Log4j2
public class EntregaInfraRepository implements EntregaRepository {
    private final EntregaSpringDataMongoDBRepository entregaSpringDataMongoDBRepository;

    @Override
    public Entrega salva(Entrega entrega) {
        log.info("[inicia] EntregaInfraRepository - salva");
        Entrega entregaSalva = entregaSpringDataMongoDBRepository.save(entrega);
        log.info("[finaliza] EntregaInfraRepository - salva");
        return entregaSalva;
    }
}