package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JarTransaction {

    @Id
    private long JarTransactionId;
    private long JarId;
    private long CustomerId;
    private long UserId;
    private long PartnerId;
    private String Action; //is jar "GIVEN" to or "TAKEN" from customer?
    private String TimeStamp;
}
