package com.restaurante.deliverysystem.cliente.application.service;

import com.restaurante.deliverysystem.cliente.application.api.ClienteRequest;
import com.restaurante.deliverysystem.cliente.application.api.ClienteCriadoResponse;
import com.restaurante.deliverysystem.cliente.application.api.ClienteDetalhadoResponse;
import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import com.restaurante.deliverysystem.credencial.application.service.CredencialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
@Log4j2
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final CredencialService credencialService;

    @Override
    public ClienteCriadoResponse cadastraNovoCliente(ClienteRequest clienteNovoRequest) {
        log.info("[inicia] ClienteApplicationService - cadastraNovoCliente");
        credencialService.criaNovaCredencial(clienteNovoRequest);
        Cliente cliente = clienteRepository.salva(new Cliente(clienteNovoRequest));
        log.info("[finaliza] ClienteApplicationService - cadastraNovoCliente");
        return new ClienteCriadoResponse(cliente);
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente, String emailCliente) {
        log.info("[inicia] ClienteApplicationService - buscaClientePorId");
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        log.info("[finaliza] ClienteApplicationService - buscaClientePorId");
        return new ClienteDetalhadoResponse(clientePorEmail);
    }

    @Override
    public void alteraCliente(ClienteRequest alteraClienteRequest, UUID idCliente, String emailCliente) {
        log.info("[inicia] ClienteApplicationService - alteraCliente");
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        clientePorEmail.alteraCliente(alteraClienteRequest);
        credencialService.criaNovaCredencial(alteraClienteRequest);
        clienteRepository.salva(clientePorEmail);
        log.info("[finaliza] ClienteApplicationService - alteraCliente");
    }

    @Override
    public void deletaCliente(UUID idCliente, String emailCliente) {
        log.info("[inicia] ClienteApplicationService - deletaCliente");
        Cliente clientePorEmail = clienteRepository.clientePorEmail(emailCliente);
        clienteRepository.clientePorId(idCliente);
        clientePorEmail.validaCliente(idCliente);
        log.info("Cliente validado - O token pertence ao cliente");
        clienteRepository.deletaClientePorId(idCliente);
        log.info("[finaliza] ClienteApplicationService - deletaCliente");
    }
}
