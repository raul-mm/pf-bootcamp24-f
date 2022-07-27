package com.bootcamp.ms.microservicerequestqueue.service.impl;

import com.bootcamp.ms.commons.entity.WalletBc;
import com.bootcamp.ms.microservicerequestqueue.WallteBcConfig;
import com.bootcamp.ms.microservicerequestqueue.service.WalletBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.HashMap;
import java.util.Map;

@Service
public class WalletServiceImpl implements WalletBcService {

    @Autowired
    private WebClient.Builder client;

    @Autowired
    private WallteBcConfig clientConfig;

    @Override
    public Mono<WalletBc> find(String id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return client.baseUrl(clientConfig.getUrl())
                .build()
                .get()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(WalletBc.class);
    }
}
