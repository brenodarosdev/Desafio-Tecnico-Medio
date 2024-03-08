package com.restaurante.deliverysystem.entrega.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Entrega")
public class Entrega {
    @Id
    private UUID idEntrega;
    @Indexed
    private UUID idPedido;
    @NotBlank
    private String nomeDoEntregador;
    @NotNull
    private StatusEntrega status;
    @NotBlank
    private String bairro;
    @NotBlank
    private String rua;
    @NotBlank
    private String numeroDaCasa;
    private LocalDateTime dataHoraDaEntrega;

    public Entrega(UUID idEntrega, UUID idPedido, String nomeDoEntregador, StatusEntrega status,
                   String bairro, String rua, String numeroDaCasa, LocalDateTime dataHoraDaEntrega) {
        this.idEntrega = UUID.randomUUID();
        this.idPedido = idPedido;
        this.nomeDoEntregador = nomeDoEntregador;
        this.status = status;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroDaCasa = numeroDaCasa;
        this.dataHoraDaEntrega = null;
    }
}
