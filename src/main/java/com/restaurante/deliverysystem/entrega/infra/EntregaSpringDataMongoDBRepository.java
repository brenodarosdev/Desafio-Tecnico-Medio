package com.restaurante.deliverysystem.entrega.infra;

import com.restaurante.deliverysystem.entrega.domain.Entrega;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EntregaSpringDataMongoDBRepository extends MongoRepository<Entrega, UUID> {
}
