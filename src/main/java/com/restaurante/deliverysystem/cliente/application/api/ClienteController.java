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
    public ClienteCriadoResponse postCadastraNovoCliente(CienteRequest clienteNovoRequest) {
        log.info("[inicia] ClienteController - postCadastraNovoCliente");
        ClienteCriadoResponse clienteCriadoResponse = clienteService.cadastraNovoCliente(clienteNovoRequest);
        log.info("[finaliza] ClienteController - postCadastraNovoCliente");
        return clienteCriadoResponse;
    }

    @Override
    public ClienteDetalhadoResponse getBuscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteController - getBuscaClientePorId");
        ClienteDetalhadoResponse clienteDetalhadoResponse = clienteService.buscaClientePorId(idCliente);
        log.info("[finaliza] ClienteController - getBuscaClientePorId");
        return clienteDetalhadoResponse;
    }

    @Override
    public void patchAlteraCliente(CienteRequest alteraClienteRequest, UUID idCliente) {
        log.info("[inicia] ClienteController - patchAlteraCliente");
        log.info("[finaliza] ClienteController - patchAlteraCliente");
    }
    // Testar!
}
