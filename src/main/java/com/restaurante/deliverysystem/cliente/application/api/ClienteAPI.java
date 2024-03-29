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
    @PostMapping("/novoCliente")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria novo Cliente")
    ClienteCriadoResponse postCadastraNovoCliente(@RequestBody @Valid ClienteRequest clienteNovoRequest);

    @GetMapping("/buscaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Cliente por ID")
    ClienteDetalhadoResponse getBuscaClientePorId(@RequestHeader(name = "Authorization") String token,
                                                  @PathVariable UUID idCliente);

    @PatchMapping("/editaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Cliente")
    void patchAlteraCliente(@RequestHeader(name = "Authorization") String token,
                            @RequestBody @Valid ClienteRequest alteraClienteRequest, @PathVariable UUID idCliente);

    @DeleteMapping("/deletaCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta Cliente")
    void deleteDeletaCliente(@RequestHeader(name = "Authorization") String token,
                             @PathVariable UUID idCliente);
}
