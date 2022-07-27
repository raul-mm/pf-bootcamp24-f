package com.bootcamp.ms.commons.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "requestQueue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestQueueBc {

    @Id
    private String id;
    private LocalDate date;
    private double amount;
    private String typePay;
    private int flag;
    private String idWallteBc;
    private WalletBc walletBc;

}
