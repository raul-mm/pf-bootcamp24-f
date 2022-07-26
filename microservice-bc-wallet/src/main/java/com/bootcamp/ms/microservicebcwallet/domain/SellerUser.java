package com.bootcamp.ms.microservicebcwallet.domain;

import com.bootcamp.ms.commons.entity.Client;
import com.bootcamp.ms.commons.entity.Wallet;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "sellerUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerUser {

    @Id
    private String id;
    private Client client;
    private LocalDate dateReg;
    private String idWalletYanki;

}
