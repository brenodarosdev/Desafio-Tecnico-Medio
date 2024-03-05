package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteNovoRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteCriadoResponse cadastraNovoCliente(CienteNovoRequest clienteNovoRequest) {
        log.info("[inicia] ClienteApplicationService - cadastraNovoCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteNovoRequest));
        log.info("[finaliza] ClienteApplicationService - cadastraNovoCliente");
        return new ClienteCriadoResponse(cliente);
    }
}
