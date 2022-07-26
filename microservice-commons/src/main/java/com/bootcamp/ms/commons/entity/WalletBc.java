package com.bootcamp.ms.commons.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "walletBC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WalletBc {

    @Id
    private String id;
    private String type;
    private LocalDate date;
    private Double amount;
    private String idClient;
    private Client client;
    private String numberDocument;
    private String idCardDebit;
    private CardDebit cardDebit;
}
