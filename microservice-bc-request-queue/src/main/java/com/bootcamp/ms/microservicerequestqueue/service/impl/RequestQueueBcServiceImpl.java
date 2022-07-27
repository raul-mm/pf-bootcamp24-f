package com.bootcamp.ms.microservicerequestqueue.service.impl;

import com.bootcamp.ms.microservicerequestqueue.producer.repository.RequestQueueBcRepository;
import com.bootcamp.ms.microservicerequestqueue.service.RequestQueueBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.bootcamp.ms.commons.entity.RequestQueueBc;

@Service
public class RequestQueueBcServiceImpl implements RequestQueueBcService {

    @Autowired
    private RequestQueueBcRepository walletRepository;

    @Override
    public Flux<RequestQueueBc> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Mono<RequestQueueBc> findById(String id) {
        return walletRepository.findById(id);
    }

    @Override
    public Mono<RequestQueueBc> save(RequestQueueBc wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Mono<Void> delete(RequestQueueBc wallet) {
        return walletRepository.delete(wallet);
    }

}
