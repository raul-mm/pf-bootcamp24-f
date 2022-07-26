package com.bootcamp.ms.microservicebcwallet.service.impl;

import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
import com.bootcamp.ms.microservicebcwallet.repository.TasasBcRepository;
import com.bootcamp.ms.microservicebcwallet.service.TasasBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class TasasBcServiceImpl implements TasasBcService {

  @Autowired
  private TasasBcRepository tasasBcRepository;

  @Override
  public Flux<TasasBc> findAll() {
    return tasasBcRepository.findAll();
  }

  @Override
  public Mono<TasasBc> findById(String id) {
    return tasasBcRepository.findById(id);
  }

  @Override
  public Mono<TasasBc> save(TasasBc tasasBC) {
    return tasasBcRepository.save(tasasBC);
  }

  @Override
  public Mono<Void> delete(TasasBc tasasBC) {
    return tasasBcRepository.delete(tasasBC);
  }

}
