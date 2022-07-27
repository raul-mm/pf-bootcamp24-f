package com.bootcamp.ms.microservicerequestqueue.producer;

import com.bootcamp.ms.commons.entity.RequestQueueBc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);

    private final KafkaTemplate<String, RequestQueueBc> kafkaTemplate;

    public KafkaStringProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, RequestQueueBc> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(RequestQueueBc message) {
        LOGGER.info("RequestQueueBc message {}", message);
        this.kafkaTemplate.send("bootcamp-Topic2", message);
    }

}