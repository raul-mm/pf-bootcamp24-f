package com.bootcamp.ms.client.service.impl;

import com.bootcamp.ms.commons.entity.Client;
import com.bootcamp.ms.client.repository.ClientRepository;
import com.bootcamp.ms.client.service.ClientService;
import com.bootcamp.ms.commons.entity.ProductBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Flux<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Mono<Client> findById(String id) {
    return clientRepository.findById(id);
  }

  @Override
  public Mono<Client> save(Client client) {
    return clientRepository.save(client);
  }

  @Override
  public Mono<Void> delete(Client client) {
    return clientRepository.delete(client);
  }

  @Override
  public Optional<Client> findByDocumentNumber(String description) {
    return clientRepository.findAll()
            .toStream()
            .filter(c -> c.getDocumentNumber().contains(description))
            .findFirst();
  }
}
