package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private long UserId;
    private String Name;
    private int Contact;
    private String Address;
    private int TotalNumberofJars;
    private int NumberofJarsinInventory;
    private int NumberofCustomers;

}
