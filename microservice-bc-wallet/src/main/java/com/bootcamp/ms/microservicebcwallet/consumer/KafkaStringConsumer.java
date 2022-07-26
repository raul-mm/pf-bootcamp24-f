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

    @KafkaListener(topics = "bootcamp-Topic2" , groupId = "group_id2")
    public void consume2(WalletBc message) {
        logger.info("Actualizando monto del monedero...");
        walletService.findById(message.getId()).flatMap(w -> {
            double amount = w.getAmount();

            if(!message.getNumberDocument().isEmpty()){
                if(amount > message.getAmount()){
                    amount -= message.getAmount();
                }
            }else{
                amount += message.getAmount();
            }
            w.setAmount(amount);

            return walletService.save(w);
        }).subscribe();
        logger.info("actualizó monedero!");
    }

    @KafkaListener(topics = "bootcamp-Topic3" , groupId = "group_id3")
    public void consume3(WalletBc message) {
        logger.info("Asociando monedero a una débito...");

        walletService.findById(message.getId()).flatMap(w -> {
            logger.info("XXXXXX" + message.getIdCardDebit());

//            cardDebitService.findById(message.getIdCardDebit())
//                    .flatMap(p -> {
//                        logger.info(p.getDescription());
//                        bankAccount.setProductBank(p);
//                        return Mono.empty();
//                    }).subscribe();

//            bankAccountService.findById(message.getIdCardDebit())
//                    .flatMap(b -> {
//                        //w.setCardDebit(c);
//                        logger.info(b.getId());
//                        logger.info("YYYYYYY" + b.getAmount());
//                        logger.info("MONTO DEL WALLET" + w.getAmount());
//                        double amount = b.getAmount() + w.getAmount();
//
//                        b.setAmount(amount);
//                        logger.info("del card debit : " + b.getAmount());
//
//                        bankAccountService.save(b).subscribe();
//
//                        return Mono.empty();
//                    }).subscribe();
//
//            return Mono.empty();

            cardDebitService.findById(message.getIdCardDebit())
                    .flatMap(c -> {
                        bankAccountService.findById(c.getIdBankAccount())
                                .flatMap(b -> {
                                    logger.info(b.getId());
                                    logger.info("YYYYYYY" + b.getAmount());
                                    logger.info("MONTO DEL WALLET" + w.getAmount());
                                    double amount = b.getAmount() + w.getAmount();

                                    b.setAmount(amount);
                                    c.getBankAccount().setAmount(amount);
                                    logger.info("del card debit : " + b.getAmount());
                                    logger.info("del card debit : " + c.getBankAccount().getAmount());

                                    w.setIdCardDebit(message.getIdCardDebit());
                                    w.setCardDebit(c);

                                    walletService.save(w).subscribe();
                                    bankAccountService.save(b).subscribe();
                                    cardDebitService.save(c).subscribe();
                                    return Mono.empty();
                                }).subscribe();
                        return Mono.empty();
                    }).subscribe();

            return Mono.empty();
        }).subscribe();
        logger.info("asociado correctamente el monedero!");
    }

}