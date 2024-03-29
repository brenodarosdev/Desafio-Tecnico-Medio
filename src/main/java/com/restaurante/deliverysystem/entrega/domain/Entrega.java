package com.restaurante.deliverysystem.entrega.domain;

import com.restaurante.deliverysystem.entrega.application.api.EntregaRequest;
import com.restaurante.deliverysystem.handler.APIException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Entrega")
public class Entrega {
    @Id
    private UUID idEntrega;
    @Indexed(unique = true)
    private UUID idPedido;
    @NotNull
    private StatusEntrega status;
    @NotBlank(message = "O campo nomeDoEntregador não pode estar vazio")
    private String nomeDoEntregador;
    @NotBlank(message = "O campo bairro não pode estar vazio")
    private String bairro;
    @NotBlank(message = "O campo rua não pode estar vazio")
    private String rua;
    @NotBlank(message = "O campo numeroDaCasa não pode estar vazio")
    private String numeroDaCasa;
    private LocalDateTime dataHoraDaEntrega;

    public Entrega(EntregaRequest entregaNovoRequest, UUID idPedido) {
        this.idEntrega = UUID.randomUUID();
        this.idPedido = idPedido;
        this.status = StatusEntrega.PREPARANDO_PEDIDO;
        this.nomeDoEntregador = entregaNovoRequest.getNomeDoEntregador();
        this.bairro = entregaNovoRequest.getBairro();
        this.rua = entregaNovoRequest.getRua();
        this.numeroDaCasa = entregaNovoRequest.getNumeroDaCasa();
        this.dataHoraDaEntrega = null;
    }

    public void alteraEntrega(EntregaRequest entregaAlteraRequest) {
        this.nomeDoEntregador = entregaAlteraRequest.getNomeDoEntregador();
        this.bairro = entregaAlteraRequest.getBairro();
        this.rua = entregaAlteraRequest.getRua();
        this.numeroDaCasa = entregaAlteraRequest.getNumeroDaCasa();
    }

    public void alteraStatusParaACaminho() {
        if (!this.status.equals(StatusEntrega.A_CAMINHO)) {
            this.status = StatusEntrega.A_CAMINHO;
        } else {
            throw APIException.build(HttpStatus.CONFLICT, "O status já está definido para A Caminho");
        }
    }

    public void alteraStatusParaEntregue() {
        if (!this.status.equals(StatusEntrega.ENTREGUE)) {
            this.status = StatusEntrega.ENTREGUE;
            this.dataHoraDaEntrega = LocalDateTime.now();
        } else {
            throw APIException.build(HttpStatus.CONFLICT,"O status já está definido para Entregue");
        }
    }
}
