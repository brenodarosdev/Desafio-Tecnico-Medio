package com.restaurante.deliverysystem.authentication.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Token {
    private String token;
    private String tipo;

    public Token(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
}
