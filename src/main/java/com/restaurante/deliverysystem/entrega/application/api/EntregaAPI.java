package com.restaurante.deliverysystem.entrega.application.api;

import com.restaurante.deliverysystem.entrega.domain.Entrega;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Entrega")
@RequestMapping("/entrega")
public interface EntregaAPI {
    @PostMapping("/novaEntrega/{idPedido}")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria nova Entrega")
    EntregaCriadaResponse postCriaNovaEntrega(@Valid @RequestBody EntregaRequest entregaNovoRequest,
                                              @PathVariable UUID idPedido);

    @GetMapping("/{idEntrega}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Busca Entrega por ID")
    EntregaDetalhadaResponse getBuscaEntregaPorId(@PathVariable UUID idEntrega);

    @PatchMapping("/editaEntrega/{idEntrega}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Altera Entrega")
    void patchAlteraEntrega(@Valid @RequestBody EntregaRequest entregaAlteraRequest, @PathVariable UUID idEntrega);

    @PatchMapping("/aCaminho/{idEntrega}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Muda status para A_CAMINHO")
    void patchAlteraStatusParaACaminho(@PathVariable UUID idEntrega);

    @PatchMapping("/entregue/{idEntrega}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Muda status para ENTREGUE")
    void patchAlteraStatusParaEntregue(@PathVariable UUID idEntrega);
}
