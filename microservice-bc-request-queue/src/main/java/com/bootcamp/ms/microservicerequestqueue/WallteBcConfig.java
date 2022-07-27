package com.bootcamp.ms.microservicerequestqueue;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class WallteBcConfig {

    @Value("${endpoint.wallet}")
    private String url;

}
