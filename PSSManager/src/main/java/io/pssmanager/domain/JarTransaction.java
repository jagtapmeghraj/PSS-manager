package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class JarTransaction {

    @Id
    private Long JarTransactionId;
    private Jar Jar;
    private Customer Customer;
    private User User;
    private Partner Partner;
    private String Action; //is jar "GIVEN" to or "TAKEN" from customer?
    private Timestamp TimeStamp;
}
