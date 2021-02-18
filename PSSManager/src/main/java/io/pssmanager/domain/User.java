package io.pssmanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "Name is required")
    private String name;
    @Size(min=4, max=10, message = "Please use 4 to 10 characters")
    @Column(updatable = false, unique = true)
    private String userIdentifier;
    @NotBlank(message = "Contact number is required")
    private String contact;
    @NotBlank(message = "Address is required")
    private String address;
    private Integer totalNumberofJars;
    private Integer numberofJarsinInventory;
    private Integer numberofCustomers;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date created_At;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updated_At;

    @OneToMany
    private List<Customer> listofCustomers;
    @OneToMany
    private List<Jar> listofJars;
    @OneToMany
    private List<Partner> listofPartners;
    @OneToMany
    private List<JarTransaction> listofJarTransactions;
    @OneToMany
    private List<MoneyTransaction> listofMoneyTransactions;

    public User() {
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
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

    public Integer getTotalNumberofJars() {
        return totalNumberofJars;
    }

    public void setTotalNumberofJars(Integer totalNumberofJars) {
        this.totalNumberofJars = totalNumberofJars;
    }

    public Integer getNumberofJarsinInventory() {
        return numberofJarsinInventory;
    }

    public void setNumberofJarsinInventory(Integer numberofJarsinInventory) {
        this.numberofJarsinInventory = numberofJarsinInventory;
    }

    public Integer getNumberofCustomers() {
        return numberofCustomers;
    }

    public void setNumberofCustomers(Integer numberofCustomers) {
        this.numberofCustomers = numberofCustomers;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }
}
