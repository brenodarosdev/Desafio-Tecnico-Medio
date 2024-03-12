package com.restaurante.deliverysystem.entrega.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EntregaRequest {
    @NotBlank
    private String nomeDoEntregador;
    @NotBlank
    private String bairro;
    @NotBlank
    private String rua;
    @NotBlank
    private String numeroDaCasa;
}
