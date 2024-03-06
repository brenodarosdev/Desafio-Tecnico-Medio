package com.restaurante.deliverysystem.pedido.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Pedido")
public class Pedido {
    @Id
    private UUID idPedido;
    @Indexed
    private UUID idCliente;
    @NotEmpty
    private List<@Valid ItemCardapio> itens;
    @NotNull
    private String observacoes;
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valor;
    @NotNull
    private LocalDateTime dataHoraDoPedido;

    public Pedido(UUID idPedido, UUID idCliente, List<@Valid ItemCardapio> itens, String observacoes, BigDecimal valor,
                  LocalDateTime dataHoraDoPedido) {
        this.idPedido = UUID.randomUUID();
        this.idCliente = idCliente;
        this.itens = itens;
        this.observacoes = observacoes;
        this.valor = calculaValor(itens);
        this.dataHoraDoPedido = LocalDateTime.now();
    }

    public BigDecimal calculaValor(List<ItemCardapio> itens) {
        BigDecimal total = new BigDecimal(0.0);
        for (ItemCardapio item : itens) {
            total = total.add(item.getPreco());
        }
        return total;
    }
}