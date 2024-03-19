package com.restaurante.deliverysystem.entrega.infra;

import com.restaurante.deliverysystem.entrega.application.api.EntregaCriadaResponse;
import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;
import com.restaurante.deliverysystem.entrega.application.repository.EntregaRepository;
import com.restaurante.deliverysystem.entrega.domain.Entrega;
import com.restaurante.deliverysystem.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
        try {
        Entrega entregaSalva = entregaSpringDataMongoDBRepository.save(entrega);
        log.info("[finaliza] EntregaInfraRepository - salva");
        return entregaSalva;
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe uma Entrega cadastrada para este Pedido!");
        }
    }

    @Override
    public Entrega entregaPorId(UUID idEntrega) {
        log.info("[inicia] EntregaInfraRepository - entregaPorId");
        Entrega entrega = entregaSpringDataMongoDBRepository.findByIdEntrega(idEntrega)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,"Entrega não encontrada!"));
        log.info("[finaliza] EntregaInfraRepository - entregaPorId");
        return entrega;
    }

    @Override
    public void deletaEntregaPorId(UUID idEntrega) {
        log.info("[inicia] EntregaInfraRepository - deletaEntregaPorId");
        entregaSpringDataMongoDBRepository.deleteByIdEntrega(idEntrega);
        log.info("[finaliza] EntregaInfraRepository - deletaEntregaPorId");
    }
}
