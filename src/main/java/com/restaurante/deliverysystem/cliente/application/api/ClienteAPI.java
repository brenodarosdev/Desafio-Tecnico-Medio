package com.restaurante.deliverysystem.cliente.application.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo Cliente")
    public ClienteCriadoResponse postNovoCliente(@RequestBody @Valid CienteNovoRequest cienteNovoRequest);
}
