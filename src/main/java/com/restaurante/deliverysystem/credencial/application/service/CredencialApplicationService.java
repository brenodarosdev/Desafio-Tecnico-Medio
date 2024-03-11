package com.restaurante.deliverysystem.credencial.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import com.restaurante.deliverysystem.credencial.application.repository.CredencialRepository;
import com.restaurante.deliverysystem.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class CredencialApplicationService implements CredencialService {
    private final CredencialRepository credencialRepository;

    @Override
    public void criaNovaCredencial(CienteRequest clienteNovoRequest) {
        log.info("[inicia] CredencialApplicationService - criaNovaCredencial");
        var novaCredencial = new Credencial(clienteNovoRequest.getEmail(), clienteNovoRequest.getSenha());
        credencialRepository.salva(novaCredencial);
        log.info("[finaliza] CredencialApplicationService - criaNovaCredencial");
    }

    @Override
    public Credencial buscaCredencialPorEmail(String email) {
        log.info("[inicia] CredencialApplicationService - buscaCredencialPorEmail");
        Credencial credencial = credencialRepository.buscaCredencialPorEmail(email);
        log.info("[finaliza] CredencialApplicationService - buscaCredencialPorEmail");
        return credencial;
    }
}
