package com.restaurante.deliverysystem.entrega.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EntregaRequest {
    @NotBlank(message = "O campo nomeDoEntregador não pode estar vazio")
    private String nomeDoEntregador;
    @NotBlank(message = "O campo bairro não pode estar vazio")
    private String bairro;
    @NotBlank(message = "O campo rua não pode estar vazio")
    private String rua;
    @NotBlank(message = "O campo numeroDaCasa não pode estar vazio")
    private String numeroDaCasa;
}
