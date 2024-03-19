package com.restaurante.deliverysystem.cliente.infra;

import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import com.restaurante.deliverysystem.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.prefs.AbstractPreferences;

@RequiredArgsConstructor
@Repository
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataMongoDBRepository clienteSpringDataMongoDBRepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        try {
        Cliente clienteSalvo = clienteSpringDataMongoDBRepository.save(cliente);
        log.info("[finaliza] ClienteInfraRepository - salva");
        return clienteSalvo;
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um Cliente cadastrado com este email!");
        }
    }

    @Override
    public Cliente clientePorId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - clientePorId");
        Cliente cliente = clienteSpringDataMongoDBRepository.findByIdCliente(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Cliente não encontrado!"));
        log.info("[finaliza] ClienteInfraRepository - clientePorId");
        return cliente;
    }

    @Override
    public void deletaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - deletaClientePorId");
        clienteSpringDataMongoDBRepository.deleteByIdCliente(idCliente);
        log.info("[finaliza] ClienteInfraRepository - deletaClientePorId");
    }

    @Override
    public Cliente clientePorEmail(String emailCliente) {
        log.info("[inicia] ClienteInfraRepository - clientePorEmail");
        Cliente cliente = clienteSpringDataMongoDBRepository.findByEmail(emailCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Cliente não encontrado por email!"));
        log.info("[finaliza] ClienteInfraRepository - clientePorEmail");
        return cliente;
    }
}
