package com.restaurante.deliverysystem.credencial.infra;

import com.restaurante.deliverysystem.credencial.application.repository.CredencialRepository;
import com.restaurante.deliverysystem.credencial.domain.Credencial;
import com.restaurante.deliverysystem.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Log4j2
public class CredencialInfraRepository implements CredencialRepository {
    private final CredencialSpringDataMongoDBRepository credencialSpringDataMongoDBRepository;

    @Override
    public Credencial salva(Credencial novaCredencial) {
        log.info("[inicia] CredencialInfraRepository - salva");
        Credencial credencialSalva = credencialSpringDataMongoDBRepository.save(novaCredencial);
        log.info("[finaliza] CredencialInfraRepository - salva");
        return credencialSalva;
    }

    @Override
    public Credencial buscaCredencialPorEmail(String email) {
        log.info("[inicia] CredencialInfraRepository - buscaCredencialPorEmail");
        Credencial credencial = credencialSpringDataMongoDBRepository.findByEmail(email)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o Email informado!"));
        log.info("[finaliza] CredencialInfraRepository - buscaCredencialPorEmail");
        return credencial;
    }
}
