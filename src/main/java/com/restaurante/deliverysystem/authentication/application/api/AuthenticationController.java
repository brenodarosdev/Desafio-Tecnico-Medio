package com.restaurante.deliverysystem.authentication.application.api;

import com.restaurante.deliverysystem.authentication.application.service.AuthenticationService;
import com.restaurante.deliverysystem.authentication.domain.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
public class AuthenticationController implements AuthenticationAPI {
    private final AuthenticationService authenticationService;

    @Override
    public TokenResponse autenticaCliente(AuthenticationRequest authenticationRequest) {
        log.info("[inicia] AuthenticationController - autenticaCliente");
        Token token = authenticationService.autentica(authenticationRequest.getUserPassToken());
        log.info("[finaliza] AuthenticationController - autenticaCliente");
        return new TokenResponse(token);
    }
}
