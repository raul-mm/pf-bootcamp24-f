package com.bootcamp.ms.microservicerequestqueue.infraestructure;

import com.bootcamp.ms.commons.entity.RequestQueueBc;
import com.bootcamp.ms.microservicerequestqueue.producer.KafkaStringProducer;
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
    public void sendMessageToKafkaTopic(@RequestBody RequestQueueBc message) {
        this.kafkaStringProducer.sendMessage(message);
    }
}
