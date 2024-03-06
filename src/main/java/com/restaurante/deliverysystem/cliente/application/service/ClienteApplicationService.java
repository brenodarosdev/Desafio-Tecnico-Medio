package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.CienteRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteDetalhadoResponse;
import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
@Log4j2
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteCriadoResponse cadastraNovoCliente(CienteRequest clienteNovoRequest) {
        log.info("[inicia] ClienteApplicationService - cadastraNovoCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteNovoRequest));
        log.info("[finaliza] ClienteApplicationService - cadastraNovoCliente");
        return new ClienteCriadoResponse(cliente);
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - buscaClientePorId");
        Cliente cliente = clienteRepository.clientePorId(idCliente);
        log.info("[finaliza] ClienteApplicationService - buscaClientePorId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void alteraCliente(CienteRequest alteraClienteRequest, UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - alteraCliente");
        log.info("[finaliza] ClienteApplicationService - alteraCliente");
    }
}
