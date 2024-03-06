package com.restaurante.deliverysystem.pedido.infra;

import com.restaurante.deliverysystem.pedido.domain.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PedidoSpringDataMongoDBRepository extends MongoRepository<Pedido, UUID> {
}