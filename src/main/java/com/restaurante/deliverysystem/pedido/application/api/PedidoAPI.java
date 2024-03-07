package com.restaurante.deliverysystem.pedido.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Pedido")
@RequestMapping("/pedido")
public interface PedidoAPI {
    @PostMapping("/novoPedido/{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria Pedido")
    PedidoCriadoResponse postCriaNovoPedido(@Valid @RequestBody PedidoRequest pedidoRequest, @PathVariable UUID idCliente);

    @GetMapping("/{idPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Pedido por ID")
    PedidoDetalhadoResponse getBuscaPedidoPorId(@PathVariable UUID idPedido);

    @GetMapping("/pedidos/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Lista Pedidos por ID do Cliente")
    List<PedidoDetalhadoResponse> getListaTodosPedidosPorIdCliente(@PathVariable UUID idCliente);

    @PatchMapping("/editaPedido/{idPedido}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Pedido")
    void patchAlteraPedido(@Valid @RequestBody PedidoRequest alteraPedidoRequest, @PathVariable UUID idPedido);

    @DeleteMapping("/deletaPedido/{idPedido}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta Pedido")
    void deleteDeletaPedido(@PathVariable UUID idPedido);
}
