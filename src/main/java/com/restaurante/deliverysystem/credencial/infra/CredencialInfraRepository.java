package com.restaurante.deliverysystem.credencial.infra;

import com.restaurante.deliverysystem.credencial.application.repository.CredencialRepository;
import com.restaurante.deliverysystem.credencial.domain.Credencial;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class CredencialInfraRepository implements CredencialRepository {
    @Override
    public void salva(Credencial novaCredencial) {
        log.info("[inicia] CredencialInfraRepository - salva");
        log.info("[finaliza] CredencialInfraRepository - salva");
    }
}
