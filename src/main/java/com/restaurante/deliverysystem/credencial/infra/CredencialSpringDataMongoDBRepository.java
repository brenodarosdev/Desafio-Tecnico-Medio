package com.restaurante.deliverysystem.credencial.infra;

import com.restaurante.deliverysystem.credencial.domain.Credencial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CredencialSpringDataMongoDBRepository extends MongoRepository<Credencial, String> {
}
