package com.restaurante.deliverysystem.cliente.application.api;

import com.restaurante.deliverysystem.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ClienteController implements ClienteAPI {

    @Override
    public ClienteCriadoResponse postCadastraNovoCliente(CienteNovoRequest clienteNovoRequest) {
        log.info("[inicia] ClienteController - postCadastraNovoCliente");
        log.info("[finaliza] ClienteController - postCadastraNovoCliente");
        return null;
    }
}
