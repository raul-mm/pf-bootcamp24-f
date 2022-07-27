package com.bootcamp.ms.microservicetransationqueue.consumer;

import com.bootcamp.ms.microservicetransationqueue.domain.TransactionQueueBc;
import com.bootcamp.ms.microservicetransationqueue.service.TransactionQueueBcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class KafkaStringConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @Autowired
    private TransactionQueueBcService walletService;

    @KafkaListener(topics = "bootcamp-Topic3" , groupId = "group_id3")
    public void consume2(TransactionQueueBc message) {
        logger.info("Actualizando monto del monedero 3...");
            double amountTemp = message.getRequestQueueBc().getAmount();
            message.setDate(LocalDate.now());
            message.setAmountConvert(amountTemp*3.93);
            walletService.save(message).subscribe();
        logger.info("actualizó 3!");
    }

}