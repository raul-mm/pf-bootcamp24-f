package com.bootcamp.ms.client.controller;

import com.bootcamp.ms.client.repository.ClientRepository;
import com.bootcamp.ms.client.service.ClientService;
import com.bootcamp.ms.client.service.impl.ClientServiceImpl;
import com.bootcamp.ms.commons.entity.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerTest {

    ClientRepository clientRepository;
    ClientService clientService;

    @BeforeEach
    void setUp() {
        clientRepository = Mockito.mock(ClientRepository.class);
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    void findByDocumentNumber() {
        Mockito.when(clientRepository.findAll()).thenReturn(Datos.CLIENT);
        Optional<Client> client = clientService.findByDocumentNumber("70976181");

        assertAll(
                () -> assertTrue(client.isPresent()),
                () -> assertEquals("70976181", client.orElseThrow().getDocumentNumber()),
                () -> assertEquals("Rivero", client.orElseThrow().getLastName()),
                () -> assertEquals("Personal", client.orElseThrow().getType())
        );
    }

    @Test
    void findById() {
        Mockito.when(clientRepository.findAll()).thenReturn(Datos.CLIENT);
        Optional<Client> client = clientService.findAll()
                .toStream()
                .filter(c -> c.getId().contains("456"))
                .findFirst();

        assertAll(
                () -> assertTrue(client.isPresent()),
                () -> assertEquals("456", client.orElseThrow().getId()),
                () -> assertEquals("Empresarial", client.orElseThrow().getType())
        );
    }
}