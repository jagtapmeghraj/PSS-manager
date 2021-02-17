package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MoneyTransaction {

    @Id
    private long MoneyTransactionId;
    private long CustomerId;
    private long UserId;
    private long PartnerId;
    private int AmountReceived;
}
