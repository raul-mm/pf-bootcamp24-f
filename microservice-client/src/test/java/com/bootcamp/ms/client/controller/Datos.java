package com.bootcamp.ms.client.controller;

import com.bootcamp.ms.commons.entity.Client;
import reactor.core.publisher.Flux;

public class Datos {

    public final static Flux<Client> CLIENT = Flux.just(
            new Client("123", "Jair", "Rivero", "70976181", "23", "Personal"),
            new Client("456", "Pedro", "Suarez", "45671124", "25", "Empresarial")
    );
}
