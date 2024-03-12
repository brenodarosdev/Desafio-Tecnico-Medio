package com.restaurante.deliverysystem.config.security.domain;

import java.util.function.Predicate;

public class ValidaConteudoAuthorizationHeader implements Predicate<String> {
    @Override
    public boolean test(String ConteudoAuthorizationHeader) {
        return ConteudoAuthorizationHeader.startsWith("Bearer");
    }
}
