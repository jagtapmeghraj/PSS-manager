package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private long CustomerId;
    private String Name;
    private int Contact;
    private String Address;
    private long JarId;
    private long UserId;
    private int DueAmount;
    private int PricePerJar;
}
