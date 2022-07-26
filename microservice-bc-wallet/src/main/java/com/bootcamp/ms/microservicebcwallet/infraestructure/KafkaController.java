package com.bootcamp.ms.microservicebcwallet.infraestructure;

import com.bootcamp.ms.commons.entity.WalletBc;
import com.bootcamp.ms.microservicebcwallet.producer.KafkaStringProducer;
import com.bootcamp.ms.microservicebcwallet.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaStringProducer kafkaStringProducer;

    @Autowired
    private WalletService walletService;

    @Autowired
    KafkaController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody WalletBc message) {
        this.kafkaStringProducer.sendMessage(message);
    }

    @GetMapping(value = "/{id}")
    public Mono<WalletBc> findBy(@PathVariable String id){
        return walletService.findById(id);
    }
}
