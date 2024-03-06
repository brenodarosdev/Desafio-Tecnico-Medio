package com.restaurante.deliverysystem.cliente.infra;

import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataMongoDBRepository clienteSpringDataMongoDBRepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        Cliente clienteSalvo = clienteSpringDataMongoDBRepository.save(cliente);
        log.info("[finaliza] ClienteInfraRepository - salva");
        return clienteSalvo;
    }

    @Override
    public Cliente clientePorId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - clientePorId");
        // TODO Tratar exeption
        Cliente cliente = clienteSpringDataMongoDBRepository.findByIdCliente(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        log.info("[finaliza] ClienteInfraRepository - clientePorId");
        return cliente;
    }

    @Override
    public void deletaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - deletaClientePorId");
        clienteSpringDataMongoDBRepository.deleteByIdCliente(idCliente);
        log.info("[finaliza] ClienteInfraRepository - deletaClientePorId");
    }
}
