package com.restaurante.deliverysystem.authentication.application.service;

import com.restaurante.deliverysystem.authentication.domain.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthenticationService {
    Token autentica(UsernamePasswordAuthenticationToken userPassToken);
}
