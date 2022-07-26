package com.bootcamp.ms.microservicebcwallet.producer.repository;

import com.bootcamp.ms.commons.entity.WalletBc;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WalletRepository extends ReactiveMongoRepository<WalletBc, String> {

}
