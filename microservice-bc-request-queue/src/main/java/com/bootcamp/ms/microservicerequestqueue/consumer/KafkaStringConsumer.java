package com.bootcamp.ms.microservicerequestqueue.consumer;

import com.bootcamp.ms.microservicerequestqueue.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.bootcamp.ms.commons.entity.RequestQueueBc;
import java.time.LocalDate;

@Component
public class KafkaStringConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @Autowired
    private RequestQueueBcService walletService;

    @Autowired
    private WalletBcService walletBcService;

    @KafkaListener(topics = "bootcamp-Topic2" , groupId = "group_id2")
    public void consume2(RequestQueueBc message) {
        logger.info("Actualizando monto del monedero 2...");
        walletBcService.find(message.getIdWallteBc())
                .flatMap(c -> {
                    message.setWalletBc(c);
                    message.setDate(LocalDate.now());
                    return walletService.save(message);
                }).subscribe();
        logger.info("actualizó 2!");
    }

}