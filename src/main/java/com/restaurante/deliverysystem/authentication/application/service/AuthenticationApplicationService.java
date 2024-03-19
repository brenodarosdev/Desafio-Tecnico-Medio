package com.restaurante.deliverysystem.authentication.application.service;

import com.restaurante.deliverysystem.authentication.domain.Token;
import com.restaurante.deliverysystem.config.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthenticationApplicationService implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public Token autentica(UsernamePasswordAuthenticationToken userPassToken) {
        log.info("[inicia] AuthenticationApplicationService - autentica");
        var authentication = authenticationManager.authenticate(userPassToken);
        Token token = new Token(tokenService.geraToken(authentication), "Bearer");
        log.info("[finaliza] AuthenticationApplicationService - autentica");
        return token;
    }
}
