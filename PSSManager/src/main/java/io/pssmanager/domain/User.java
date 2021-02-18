package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long UserId;
    private String Name;
    private Integer Contact;
    private String Address;
    private Integer TotalNumberofJars;
    private Integer NumberofJarsinInventory;
    private Integer NumberofCustomers;
    private Customer customer;
    private Jar Jar;
    private Partner Partner;

}
