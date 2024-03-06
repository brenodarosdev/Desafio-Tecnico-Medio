package com.restaurante.deliverysystem.pedido.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum ItemCardapio {
    MARGHERITA(new BigDecimal("40.0")), QUATRO_QUEIJOS(new BigDecimal("35.5")),
    VEGETARIANA(new BigDecimal("30.0")), PORTUGUESA(new BigDecimal("38.0"));

    private BigDecimal preco;

    ItemCardapio(BigDecimal preco) {
        this.preco = preco;
    }
}
