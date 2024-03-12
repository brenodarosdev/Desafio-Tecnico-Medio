package com.restaurante.deliverysystem.authentication.application.api;

import com.restaurante.deliverysystem.authentication.domain.Token;
import lombok.Value;

@Value
public class TokenResponse {
    private String token;
    private String tipo;

    public TokenResponse(Token token) {
        this.token = token.getToken();
        this.tipo = token.getTipo();
    }
}
