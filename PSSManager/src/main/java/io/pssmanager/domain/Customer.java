package io.pssmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @OneToMany
    private List<Transaction> listofTransactions = new ArrayList<>();
    private Integer dueAmount;
    private Integer pricePerJar;
    private Integer numberOfJarsHeldCurrently;
    private Integer totalNumberOfJarsTakenThisMonth;
    private Integer totalCashGivenThisMonth;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getListofTransactions() {
        return listofTransactions;
    }

    public void setListofTransactions(List<Transaction> listofTransactions) {
        this.listofTransactions = listofTransactions;
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

    public Integer getNumberOfJarsHeldCurrently() {
        return numberOfJarsHeldCurrently;
    }

    public void setNumberOfJarsHeldCurrently(Integer numberOfJarsHeldCurrently) {
        this.numberOfJarsHeldCurrently = numberOfJarsHeldCurrently;
    }

    public Integer getTotalNumberOfJarsTakenThisMonth() {
        return totalNumberOfJarsTakenThisMonth;
    }

    public void setTotalNumberOfJarsTakenThisMonth(Integer totalNumberOfJarsTakenThisMonth) {
        this.totalNumberOfJarsTakenThisMonth = totalNumberOfJarsTakenThisMonth;
    }

    public Integer getTotalCashGivenThisMonth() {
        return totalCashGivenThisMonth;
    }

    public void setTotalCashGivenThisMonth(Integer totalCashGivenThisMonth) {
        this.totalCashGivenThisMonth = totalCashGivenThisMonth;
    }
}
