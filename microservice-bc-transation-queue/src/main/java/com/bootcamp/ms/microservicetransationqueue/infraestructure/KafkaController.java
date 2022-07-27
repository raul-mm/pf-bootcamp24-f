package com.bootcamp.ms.microservicetransationqueue.infraestructure;

import com.bootcamp.ms.commons.entity.CardDebit;
import com.bootcamp.ms.microservicetransationqueue.domain.TransactionQueueBc;
import com.bootcamp.ms.microservicetransationqueue.producer.KafkaStringProducer;
import com.bootcamp.ms.microservicetransationqueue.service.TransactionQueueBcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaStringProducer kafkaStringProducer;

    @Autowired
    private TransactionQueueBcService walletService;

    @Autowired
    KafkaController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody TransactionQueueBc message) {
        this.kafkaStringProducer.sendMessage(message);
    }

    @GetMapping(value = "/findAllFindIdWalletBc/{id}")
    public Flux<TransactionQueueBc> findAllFindIdWalletBc(@PathVariable String id){
        return walletService.findAllFindIdWalletBc(id);
    }

    @GetMapping(value = "/{id}")
    public Mono<TransactionQueueBc> findBy(@PathVariable String id){
        return walletService.findById(id);
    }
}
