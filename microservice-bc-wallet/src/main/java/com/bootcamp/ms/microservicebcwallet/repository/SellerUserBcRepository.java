package com.bootcamp.ms.microservicebcwallet.repository;

import com.bootcamp.ms.microservicebcwallet.domain.SellerUser;
import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SellerUserBcRepository extends ReactiveMongoRepository<SellerUser, String> {
}
