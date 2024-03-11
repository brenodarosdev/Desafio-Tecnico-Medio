package com.restaurante.deliverysystem.credencial.infra;

import com.restaurante.deliverysystem.credencial.application.repository.CredencialRepository;
import com.restaurante.deliverysystem.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Log4j2
public class CredencialInfraRepository implements CredencialRepository {
    private final CredencialSpringDataMongoDBRepository credencialSpringDataMongoDBRepository;

    @Override
    public void salva(Credencial novaCredencial) {
        log.info("[inicia] CredencialInfraRepository - salva");
        credencialSpringDataMongoDBRepository.save(novaCredencial);
        log.info("[finaliza] CredencialInfraRepository - salva");
    }
}
