package com.restaurante.deliverysystem.pedido.application.api;

import com.restaurante.deliverysystem.config.security.service.TokenService;
import com.restaurante.deliverysystem.handler.APIException;
import com.restaurante.deliverysystem.pedido.application.service.PedidoService;
import com.restaurante.deliverysystem.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class PedidoController implements PedidoAPI {
    private final PedidoService pedidoService;
    private final TokenService tokenService;

    @Override
    public PedidoCriadoResponse postCriaNovoPedido(String token, PedidoRequest pedidoRequest, UUID idCliente) {
        log.info("[inicia] PedidoController - postCriaNovoPedido");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        PedidoCriadoResponse pedidoCriadoResponse = pedidoService.criaNovoPedido(pedidoRequest, idCliente, emailCliente);
        log.info("[finaliza] PedidoController - postCriaNovoPedido");
        return pedidoCriadoResponse;
    }

    @Override
    public PedidoDetalhadoResponse getBuscaPedidoPorId(String token, UUID idPedido) {
        log.info("[inicia] PedidoController - getBuscaPedidoPorId");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        PedidoDetalhadoResponse pedidoDetalhadoResponse = pedidoService.buscaPedidoPorId(idPedido, emailCliente);
        log.info("[finaliza] PedidoController - getBuscaPedidoPorId");
        return pedidoDetalhadoResponse;
    }

    @Override
    public List<PedidoDetalhadoResponse> getListaTodosPedidosPorIdCliente(String token, UUID idCliente) {
        log.info("[inicia] PedidoController - getListaTodosPedidosPorIdCliente");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        List<PedidoDetalhadoResponse> pedidosDoCliente = pedidoService.listaTodosPedidosPorIdCliente(idCliente, emailCliente);
        log.info("[finaliza] PedidoController - getListaTodosPedidosPorIdCliente");
        return pedidosDoCliente;
    }

    @Override
    public void patchAlteraPedido(String token, PedidoRequest alteraPedidoRequest, UUID idPedido) {
        log.info("[inicia] PedidoController - patchAlteraPedido");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        pedidoService.alteraPedido(alteraPedidoRequest, idPedido, emailCliente);
        log.info("[finaliza PedidoController - patchAlteraPedido");
    }

    @Override
    public void deleteDeletaPedido(String token, UUID idPedido) {
        log.info("[inicia] PedidoController - deleteDeletaPedido");
        String emailCliente = tokenService.getEmailByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
        pedidoService.deletaPedido(idPedido, emailCliente);
        log.info("[finaliza] PedidoController - deleteDeletaPedido");
    }
}
