package com.restaurante.deliverysystem.cliente.infra;

import com.restaurante.deliverysystem.cliente.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataMongoDBRepository extends MongoRepository<Cliente, UUID> {
    Optional<Cliente> findByIdCliente(UUID idCliente);
    void deleteByIdCliente(UUID idCliente);
    Optional<Cliente> findByEmail(String emailCliente);
}
