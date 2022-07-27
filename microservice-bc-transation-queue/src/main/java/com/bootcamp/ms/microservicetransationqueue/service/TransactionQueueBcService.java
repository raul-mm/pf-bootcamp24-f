package com.bootcamp.ms.microservicetransationqueue.service;

import com.bootcamp.ms.microservicetransationqueue.domain.TransactionQueueBc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionQueueBcService {

    Flux<TransactionQueueBc> findAll();
    Mono<TransactionQueueBc> findById(String id);
    Mono<TransactionQueueBc> save(TransactionQueueBc wallet);
    Mono<Void> delete(TransactionQueueBc wallet);

    Flux<TransactionQueueBc> findAllFindIdWalletBc(String id);
}
