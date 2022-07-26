package com.bootcamp.ms.microservicebcwallet.service;

import com.bootcamp.ms.commons.entity.WalletBc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletService {

    Flux<WalletBc> findAll();
    Mono<WalletBc> findById(String id);
    Mono<WalletBc> save(WalletBc wallet);
    Mono<Void> delete(WalletBc wallet);
}
