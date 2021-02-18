package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class MoneyTransaction {

    @Id
    private Long MoneyTransactionId;
    @ManyToOne
    private Customer Customer;
    @ManyToOne
    private User User;
    @ManyToOne
    private Partner Partner;
    private Integer AmountReceived;
    private Date TimeStamp;
}
