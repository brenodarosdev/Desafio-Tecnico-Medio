package com.restaurante.deliverysystem.cliente.application.api;

import com.restaurante.deliverysystem.cliente.domain.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Cliente")
@RequestMapping("/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo Cliente")
    ClienteCriadoResponse postCadastraNovoCliente(@RequestBody @Valid CienteNovoRequest clienteNovoRequest);

    @GetMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Cliente por ID")
    ClienteDetalhadoResponse getBuscaClientePorId(@PathVariable UUID idCliente);
}
