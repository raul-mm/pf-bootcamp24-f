package com.bootcamp.ms.microservicerequestqueue.service;

import reactor.core.publisher.Flux;
import com.bootcamp.ms.commons.entity.RequestQueueBc;
import reactor.core.publisher.Mono;

public interface RequestQueueBcService {

    Flux<RequestQueueBc> findAll();
    Mono<RequestQueueBc> findById(String id);
    Mono<RequestQueueBc> save(RequestQueueBc wallet);
    Mono<Void> delete(RequestQueueBc wallet);
}
