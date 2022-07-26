package com.bootcamp.ms.microservicebcwallet;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ClientConfig {

    @Value("${endpoint.client}")
    private String url;

}
