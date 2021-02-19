package io.pssmanager.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    private Long id;
    private String name;
    private Integer contact;
    private String address;

    @OneToMany
    private List<Jar> listofJars;
    @OneToMany
    private List<JarTransaction> listofJarTransactions;
    @OneToMany
    private List<MoneyTransaction> listofMoneyTransactions;
    private Integer dueAmount;
    private Integer pricePerJar;


    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Jar> getListofJars() {
        return listofJars;
    }

    public void setListofJars(List<Jar> listofJars) {
        this.listofJars = listofJars;
    }

    public List<JarTransaction> getListofJarTransactions() {
        return listofJarTransactions;
    }

    public void setListofJarTransactions(List<JarTransaction> listofJarTransactions) {
        this.listofJarTransactions = listofJarTransactions;
    }

    public List<MoneyTransaction> getListofMoneyTransactions() {
        return listofMoneyTransactions;
    }

    public void setListofMoneyTransactions(List<MoneyTransaction> listofMoneyTransactions) {
        this.listofMoneyTransactions = listofMoneyTransactions;
    }

    public Integer getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Integer dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Integer getPricePerJar() {
        return pricePerJar;
    }

    public void setPricePerJar(Integer pricePerJar) {
        this.pricePerJar = pricePerJar;
    }
}
