package com.restaurante.deliverysystem.config.security.service;

import com.restaurante.deliverysystem.credencial.application.repository.CredencialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class AutenticacaoSecurityService implements UserDetailsService {
    private final CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("[inicia] AutenticacaoSecurityService - buscaCredencialPorEmail");
        var credencial = credencialRepository.buscaCredencialPorEmail(email);
        log.info("[finaliza] AutenticacaoSecurityService - buscaCredencialPorEmail");
        return Optional.ofNullable(credencial)
                .orElseThrow(() -> new RuntimeException("Não existe credencial para o Email informado!"));
    }
}
