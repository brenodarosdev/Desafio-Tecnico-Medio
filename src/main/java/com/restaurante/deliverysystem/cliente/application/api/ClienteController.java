package com.restaurante.deliverysystem.cliente.application.api;

import com.restaurante.deliverysystem.cliente.application.service.ClienteService;
import com.restaurante.deliverysystem.config.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
@Log4j2
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;
    private final TokenService tokenService;

    @Override
    public ClienteCriadoResponse postCadastraNovoCliente(CienteRequest clienteNovoRequest) {
        log.info("[inicia] ClienteController - postCadastraNovoCliente");
        ClienteCriadoResponse clienteCriadoResponse = clienteService.cadastraNovoCliente(clienteNovoRequest);
        log.info("[finaliza] ClienteController - postCadastraNovoCliente");
        return clienteCriadoResponse;
    }

    @Override
    public ClienteDetalhadoResponse getBuscaClientePorId(String token, UUID idCliente) {
        log.info("[inicia] ClienteController - getBuscaClientePorId");
        // TODO Implementar exception
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido!"));
        ClienteDetalhadoResponse clienteDetalhadoResponse = clienteService.buscaClientePorId(idCliente, emailCliente);
        log.info("[finaliza] ClienteController - getBuscaClientePorId");
        return clienteDetalhadoResponse;
    }

    @Override
    public void patchAlteraCliente(CienteRequest alteraClienteRequest, UUID idCliente) {
        log.info("[inicia] ClienteController - patchAlteraCliente");
        clienteService.alteraCliente(alteraClienteRequest, idCliente);
        log.info("[finaliza] ClienteController - patchAlteraCliente");
    }

    @Override
    public void deleteDeletaCliente(UUID idCliente) {
        log.info("[inicia] ClienteController - deleteDeletaCliente");
        clienteService.deletaCliente( idCliente);
        log.info("[finaliza] ClienteController - deleteDeletaCliente");
    }
}
