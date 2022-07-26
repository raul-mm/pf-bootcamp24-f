package com.bootcamp.ms.microservicebcwallet.infraestructure;

import com.bootcamp.ms.commons.entity.WalletBc;
import com.bootcamp.ms.microservicebcwallet.producer.KafkaStringProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaStringProducer kafkaStringProducer;

    @Autowired
    KafkaController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody WalletBc message) {
        this.kafkaStringProducer.sendMessage(message);
    }

    @PutMapping("/publish2")
    public void sendMessageToKafkaTopic2(@RequestBody WalletBc wallet){
        logger.info("publish2");
        logger.info(wallet.getNumberDocument());
        this.kafkaStringProducer.sendMessageUpdateAmount(wallet);
    }
}
