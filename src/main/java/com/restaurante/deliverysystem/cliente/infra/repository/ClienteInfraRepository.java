package com.restaurante.deliverysystem.cliente.infra.repository;

import com.restaurante.deliverysystem.cliente.application.repository.ClienteRepository;
import com.restaurante.deliverysystem.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

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
}