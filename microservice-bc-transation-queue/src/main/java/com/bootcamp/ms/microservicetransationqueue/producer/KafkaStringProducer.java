package com.bootcamp.ms.microservicetransationqueue.producer;

import com.bootcamp.ms.microservicetransationqueue.domain.TransactionQueueBc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);

    private final KafkaTemplate<String, TransactionQueueBc> kafkaTemplate;

    public KafkaStringProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, TransactionQueueBc> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(TransactionQueueBc message) {
        LOGGER.info("RequestQueueBc message {}", message);
        this.kafkaTemplate.send("bootcamp-Topic3", message);
    }

}