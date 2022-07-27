package com.bootcamp.ms.microservicetransationqueue.service.impl;

import com.bootcamp.ms.microservicetransationqueue.domain.TransactionQueueBc;
import com.bootcamp.ms.microservicetransationqueue.producer.repository.TransactionQueueBcRepository;
import com.bootcamp.ms.microservicetransationqueue.service.TransactionQueueBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestQueueBcServiceImpl implements TransactionQueueBcService {

    @Autowired
    private TransactionQueueBcRepository walletRepository;

    @Override
    public Flux<TransactionQueueBc> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Mono<TransactionQueueBc> findById(String id) {
        return walletRepository.findById(id);
    }

    @Override
    public Mono<TransactionQueueBc> save(TransactionQueueBc wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Mono<Void> delete(TransactionQueueBc wallet) {
        return walletRepository.delete(wallet);
    }

    @Override
    public Flux<TransactionQueueBc> findAllFindIdWalletBc(String id) {
        return walletRepository.findAll()
                .filter(m -> m.getRequestQueueBc().getIdWallteBc().equals(id));
    }

}
