package com.bootcamp.ms.microservicetransationqueue.domain;

import com.bootcamp.ms.commons.entity.RequestQueueBc;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "transactionQueue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionQueueBc {

    @Id
    private String id;
    private RequestQueueBc requestQueueBc;
    private double amountConvert;
    private LocalDate date;
    private int flag;

}
