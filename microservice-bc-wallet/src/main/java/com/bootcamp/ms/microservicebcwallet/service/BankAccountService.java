package com.bootcamp.ms.microservicebcwallet.service;

import com.bootcamp.ms.commons.entity.BankAccount;
import reactor.core.publisher.Mono;

public interface BankAccountService {

    Mono<BankAccount> findById(String id);
    Mono<BankAccount> save(BankAccount bankAccount);
}
