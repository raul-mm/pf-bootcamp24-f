package com.bootcamp.ms.microservicebcwallet.service;

import com.bootcamp.ms.microservicebcwallet.domain.SellerUser;
import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SellerUserBcService {

    public Flux<SellerUser> findAll();
    public Mono<SellerUser> findById(String id);
    public Mono<SellerUser> save(SellerUser tasasBC);
    public Mono<Void> delete(SellerUser tasasBC);
}
