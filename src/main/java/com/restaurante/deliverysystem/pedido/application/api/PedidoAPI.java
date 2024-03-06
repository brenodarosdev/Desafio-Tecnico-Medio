package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.pedido.domain.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Pedido")
@RequestMapping("/pedido")
public interface PedidoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria Pedido")
    PedidoCriadoResponse postCriaNovoPedido(@Valid @RequestBody PedidoRequest pedidoRequest);
}
