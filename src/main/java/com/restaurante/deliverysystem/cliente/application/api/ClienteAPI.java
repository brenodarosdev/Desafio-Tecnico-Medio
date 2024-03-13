package com.restaurante.deliverysystem.cliente.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Cliente")
@RequestMapping("/public/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo Cliente")
    ClienteCriadoResponse postCadastraNovoCliente(@RequestBody @Valid CienteRequest clienteNovoRequest);

    @GetMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Cliente por ID")
    ClienteDetalhadoResponse getBuscaClientePorId(@RequestHeader(name = "Authorization") String token,
                                                  @PathVariable UUID idCliente);

    @PatchMapping("/editaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Cliente")
    void patchAlteraCliente(@RequestBody @Valid CienteRequest alteraClienteRequest, @PathVariable UUID idCliente);

    @DeleteMapping("/deletaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta Cliente")
    void deleteDeletaCliente(@PathVariable UUID idCliente);
}
