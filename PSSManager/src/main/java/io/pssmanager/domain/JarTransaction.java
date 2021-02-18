package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class JarTransaction {

    @Id
    private Long JarTransactionId;
    @OneToOne
    private Jar Jar;
    @ManyToOne
    private Customer Customer;
    @ManyToOne
    private User User;
    @ManyToOne
    private Partner Partner;
    private String Action; //is jar "GIVEN" to or "TAKEN" from customer?
    private Date TimeStamp;
}
