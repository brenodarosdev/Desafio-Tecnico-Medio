package com.restaurante.deliverysystem.pedido.domain;

import com.restaurante.deliverysystem.pedido.application.api.PedidoRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    @NotEmpty(message = "O campo itens não pode estar vazio")
    private List<@Valid ItemCardapio> itens;
    @NotNull(message = "O campo observacoes não pode ser nulo")
    private String observacoes;
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo valor não pode ser menor ou igual a zero")
    private BigDecimal valor;
    @NotNull
    private LocalDateTime dataHoraDoPedido;

    public Pedido(PedidoRequest pedidoNovoRequest, UUID idCliente) {
        this.idPedido = UUID.randomUUID();
        this.idCliente = idCliente;
        this.itens = pedidoNovoRequest.getItens();
        this.observacoes = pedidoNovoRequest.getObservacoes();
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

    public void alteraPedido(PedidoRequest alteraPedidoRequest) {
        this.itens = alteraPedidoRequest.getItens();
        this.observacoes = alteraPedidoRequest.getObservacoes();
        this.valor = calculaValor(itens);
    }
}
