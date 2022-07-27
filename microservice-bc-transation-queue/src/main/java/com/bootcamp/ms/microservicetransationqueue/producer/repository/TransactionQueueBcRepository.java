package com.bootcamp.ms.microservicetransationqueue.producer.repository;

import com.bootcamp.ms.microservicetransationqueue.domain.TransactionQueueBc;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionQueueBcRepository extends ReactiveMongoRepository<TransactionQueueBc, String> {

}
