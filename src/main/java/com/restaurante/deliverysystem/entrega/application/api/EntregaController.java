package com.restaurante.deliverysystem.entrega.application.api;

import com.restaurante.deliverysystem.config.security.service.TokenService;
import com.restaurante.deliverysystem.entrega.application.service.EntregaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class EntregaController implements EntregaAPI {
    private final EntregaService entregaService;
    private final TokenService tokenService;

    @Override
    public EntregaCriadaResponse postCriaNovaEntrega(String token, EntregaRequest entregaNovoRequest, UUID idPedido) {
        log.info("[inicia] EntregaController - postCriaNovaEntrega");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido!"));
        EntregaCriadaResponse entregaCriadaResponse = entregaService.criaNovaEntrega(entregaNovoRequest, idPedido, emailCliente);
        log.info("[finaliza] EntregaController - postCriaNovaEntrega");
        return entregaCriadaResponse;
    }

    @Override
    public EntregaDetalhadaResponse getBuscaEntregaPorId(String token, UUID idEntrega) {
        log.info("[inicia] EntregaController - getBuscaEntregaPorId");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido!"));
        EntregaDetalhadaResponse entregaDetalhadaResponse = entregaService.buscaEntregaPorId(idEntrega, emailCliente);
        log.info("[finaliza] EntregaController - getBuscaEntregaPorId");
        return entregaDetalhadaResponse;
    }

    @Override
    public void patchAlteraEntrega(String token, EntregaRequest entregaAlteraRequest, UUID idEntrega) {
        log.info("[inicia] EntregaController - patchAlteraEntrega");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido!"));
        entregaService.alteraEntrega(entregaAlteraRequest, idEntrega, emailCliente);
        log.info("[finaliza] EntregaController - patchAlteraEntrega");
    }

    @Override
    public void patchAlteraStatusParaACaminho(String token, UUID idEntrega) {
        log.info("[inicia] EntregaController - patchAlteraStatusParaACaminho");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido!"));
        entregaService.alteraStatusParaACaminho(idEntrega, emailCliente);
        log.info("[finaliza] EntregaController - patchAlteraStatusParaACaminho");
    }

    @Override
    public void patchAlteraStatusParaEntregue(UUID idEntrega) {
        log.info("[inicia] EntregaController - patchAlteraStatusParaEntregue");
        entregaService.alteraStatusParaEntregue(idEntrega);
        log.info("[finaliza] EntregaController - patchAlteraStatusParaEntregue");
    }

    @Override
    public void deleteDeletaEntrega(UUID idEntrega) {
        log.info("[inicia] EntregaController - deleteDeletaEntrega");
        entregaService.deletaEntrega(idEntrega);
        log.info("[finaliza] EntregaController - deleteDeletaEntrega");
    }
}
