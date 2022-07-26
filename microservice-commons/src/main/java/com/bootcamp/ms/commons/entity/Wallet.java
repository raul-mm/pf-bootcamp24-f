package com.bootcamp.ms.commons.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "wallet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Wallet {

    @Id
    private String id;
    private String type;
    private Date date;
    private Double amount;
    private String idClient;
    private Client client;
    private String numberPhone;
    private String idCardDebit;
    private CardDebit cardDebit;
}
