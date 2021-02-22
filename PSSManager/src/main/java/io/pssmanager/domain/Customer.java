package io.pssmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Size(min=10, max=10, message = "Enter valid mobile number")
    @NotBlank(message = "Contact number is required")
    private String contact;
    @NotBlank(message = "Address is required")
    private String address;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Jar> listofJars = new ArrayList<>();
    @OneToMany
    private List<JarTransaction> listofJarTransactions = new ArrayList<>();
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
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
