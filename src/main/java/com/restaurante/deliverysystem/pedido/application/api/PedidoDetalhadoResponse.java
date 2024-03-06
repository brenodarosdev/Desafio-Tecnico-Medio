package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.pedido.domain.ItemCardapio;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
public class PedidoDetalhadoResponse {
    private UUID idPedido;
    private UUID idCliente;
    private List<@Valid ItemCardapio> itens;
    private String observacoes;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoPedido;

    public PedidoDetalhadoResponse(Pedido pedido) {
        this.idPedido = pedido.getIdPedido();
        this.idCliente = pedido.getIdCliente();
        this.itens = pedido.getItens();
        this.observacoes = pedido.getObservacoes();
        this.valor = pedido.getValor();
        this.dataHoraDoPedido = pedido.getDataHoraDoPedido();
    }
}
