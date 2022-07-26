package com.bootcamp.ms.commons.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "bankCredit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BankCredit {

    @Id
    private String id;
    private String type;
    private Integer maxMovement;
    private LocalDate date;
    private LocalDate dateExpired;
    private Double amount;
    private Double availableBalances;
    private String idProduct;
    private String idClient;
    private Client client;
    private ProductBank productBank;

    public void maxMovement(String type) {

        switch (type) {
            case "Personal":
                this.maxMovement = 5000;
                break;
            case "Empresarial":
                this.maxMovement = 10000;
                break;
            case "Tarjeta de Credito":
                this.maxMovement = 3500;
                break;
            default:
                break;
        }
    }
}
