package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.pedido.domain.ItemCardapio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class PedidoRequest {
    @NotEmpty(message = "O campo itens não pode estar vazio")
    private List<@Valid ItemCardapio> itens;
    @NotNull(message = "O campo observacoes não pode ser nulo")
    private String observacoes;
}
