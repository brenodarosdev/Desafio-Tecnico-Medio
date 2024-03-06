package com.restaurante.deliverysystem.cliente.application.api;

import com.restaurante.deliverysystem.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteCriadoResponse postCadastraNovoCliente(CienteNovoRequest clienteNovoRequest) {
        log.info("[inicia] ClienteController - postCadastraNovoCliente");
        ClienteCriadoResponse clienteCriado = clienteService.cadastraNovoCliente(clienteNovoRequest);
        log.info("[finaliza] ClienteController - postCadastraNovoCliente");
        return clienteCriado;
    }

    @Override
    public ClienteDetalhadoResponse getBuscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteController - getBuscaClientePorId");
        log.info("[finaliza] ClienteController - getBuscaClientePorId");
        return null;
    }
}
