package com.bootcamp.ms.microservicerequestqueue.service;

import com.bootcamp.ms.commons.entity.WalletBc;
import reactor.core.publisher.Mono;

public interface WalletBcService {

    Mono<WalletBc> find(String id);
}
