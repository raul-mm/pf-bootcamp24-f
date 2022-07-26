package com.bootcamp.ms.microservicebcwallet.service.impl;

import com.bootcamp.ms.commons.entity.WalletBc;
import com.bootcamp.ms.microservicebcwallet.producer.repository.WalletRepository;
import com.bootcamp.ms.microservicebcwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Flux<WalletBc> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Mono<WalletBc> findById(String id) {
        return walletRepository.findById(id);
    }

    @Override
    public Mono<WalletBc> save(WalletBc wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Mono<Void> delete(WalletBc wallet) {
        return walletRepository.delete(wallet);
    }

}
