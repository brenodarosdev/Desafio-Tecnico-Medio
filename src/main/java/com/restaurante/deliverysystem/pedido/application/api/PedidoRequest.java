package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.pedido.domain.ItemCardapio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class PedidoRequest {
    @NotEmpty
    private List<@Valid ItemCardapio> itens;
    @NotNull
    private String observacoes;
}
