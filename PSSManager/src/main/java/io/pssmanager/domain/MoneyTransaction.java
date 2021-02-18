package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class MoneyTransaction {

    @Id
    private Long MoneyTransactionId;
    private Customer Customer;
    private User User;
    private Partner Partner;
    private Integer AmountReceived;
    private Timestamp TimeStamp;
}
