package com.bootcamp.ms.microservicebcwallet.service.impl;

import com.bootcamp.ms.microservicebcwallet.domain.SellerUser;
import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
import com.bootcamp.ms.microservicebcwallet.repository.SellerUserBcRepository;
import com.bootcamp.ms.microservicebcwallet.repository.TasasBcRepository;
import com.bootcamp.ms.microservicebcwallet.service.SellerUserBcService;
import com.bootcamp.ms.microservicebcwallet.service.TasasBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class SellerUserBcServiceImpl implements SellerUserBcService {

  @Autowired
  private SellerUserBcRepository sellerUserBcRepository;

  @Override
  public Flux<SellerUser> findAll() {
    return sellerUserBcRepository.findAll();
  }

  @Override
  public Mono<SellerUser> findById(String id) {
    return sellerUserBcRepository.findById(id);
  }

  @Override
  public Mono<SellerUser> save(SellerUser tasasBC) {
    return sellerUserBcRepository.save(tasasBC);
  }

  @Override
  public Mono<Void> delete(SellerUser tasasBC) {
    return sellerUserBcRepository.delete(tasasBC);
  }

}
