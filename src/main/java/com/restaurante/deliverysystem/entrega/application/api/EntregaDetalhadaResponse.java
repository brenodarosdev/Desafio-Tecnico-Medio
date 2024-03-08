package com.restaurante.deliverysystem.entrega.application.api;

import com.restaurante.deliverysystem.entrega.domain.Entrega;
import com.restaurante.deliverysystem.entrega.domain.StatusEntrega;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class EntregaDetalhadaResponse {
    private UUID idEntrega;
    private UUID idPedido;
    private StatusEntrega status;
    private String nomeDoEntregador;
    private String bairro;
    private String rua;
    private String numeroDaCasa;
    private LocalDateTime dataHoraDaEntrega;

    public EntregaDetalhadaResponse(Entrega entrega) {
        this.idEntrega = entrega.getIdEntrega();
        this.idPedido = entrega.getIdPedido();
        this.status = entrega.getStatus();
        this.nomeDoEntregador = entrega.getNomeDoEntregador();
        this.bairro = entrega.getBairro();
        this.rua = entrega.getRua();
        this.numeroDaCasa = entrega.getNumeroDaCasa();
        this.dataHoraDaEntrega = entrega.getDataHoraDaEntrega();
    }
}
