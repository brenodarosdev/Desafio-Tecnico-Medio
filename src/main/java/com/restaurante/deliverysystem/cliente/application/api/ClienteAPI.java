package com.restaurante.deliverysystem.cliente.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Cliente")
@RequestMapping("/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo Cliente")
    ClienteCriadoResponse postCadastraNovoCliente(@RequestBody @Valid CienteNovoRequest clienteNovoRequest);
}
