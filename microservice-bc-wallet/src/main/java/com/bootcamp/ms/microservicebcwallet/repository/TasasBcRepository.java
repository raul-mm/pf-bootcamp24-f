package com.bootcamp.ms.microservicebcwallet.repository;

import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TasasBcRepository extends ReactiveMongoRepository<TasasBc, String> {
}
