package com.bootcamp.ms.microservicebcwallet.consumer;

import com.bootcamp.ms.commons.entity.WalletBc;
import com.bootcamp.ms.microservicebcwallet.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.time.LocalDate;

@Component
public class KafkaStringConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @Autowired
    private WalletService walletService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private MaestroService maestroService;
    @Autowired
    private CardDebitService cardDebitService;

    @Autowired
    private BankAccountService bankAccountService;

    @KafkaListener(topics = "bootcamp-Topic" , groupId = "group_id")
    public void consume(WalletBc message) {
        logger.info("Creando monedero...");

        clientService.find(message.getIdClient())
                .flatMap(c -> {
                    message.setClient(c);
                    message.setDate(LocalDate.now());
                    logger.info("Consuming Message {}", message);
                    return walletService.save(message);
                }).subscribe();
        logger.info("grabó monedero!");
    }

}