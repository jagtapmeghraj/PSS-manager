package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private Long CustomerId;
    private String Name;
    private Integer Contact;
    private String Address;
    private Jar Jar;
    private User User ;
    private Integer DueAmount;
    private Integer PricePerJar;

    public Customer() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getContact() {
        return Contact;
    }

    public void setContact(Integer contact) {
        Contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getDueAmount() {
        return DueAmount;
    }

    public void setDueAmount(Integer dueAmount) {
        DueAmount = dueAmount;
    }

    public Integer getPricePerJar() {
        return PricePerJar;
    }

    public void setPricePerJar(Integer pricePerJar) {
        PricePerJar = pricePerJar;
    }
}
