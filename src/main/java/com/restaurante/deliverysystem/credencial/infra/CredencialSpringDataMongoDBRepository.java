package com.restaurante.deliverysystem.credencial.infra;

import com.restaurante.deliverysystem.credencial.domain.Credencial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CredencialSpringDataMongoDBRepository extends MongoRepository<Credencial, String> {
    Optional<Credencial> findByEmail(String email);
}
