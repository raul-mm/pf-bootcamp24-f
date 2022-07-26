package com.bootcamp.ms.microservicebcwallet.service;

import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TasasBcService {

    public Flux<TasasBc> findAll();
    public Mono<TasasBc> findById(String id);
    public Mono<TasasBc> save(TasasBc tasasBC);
    public Mono<Void> delete(TasasBc tasasBC);
}
