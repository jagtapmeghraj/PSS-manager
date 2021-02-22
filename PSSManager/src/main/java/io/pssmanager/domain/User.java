package io.pssmanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Username needs to be an email")
    @NotBlank(message = "username is required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Please enter your full name")
    private String fullName;
    @NotBlank(message = "Password field is required")
    private String password;
    @Transient
    private String confirmPassword;
    @Size(min=10, max=10, message = "Enter valid mobile number")
    @Column(updatable = false, unique = true)
    @NotBlank(message = "Contact number is required")
    private String userContact;

    @NotBlank(message = "Address is required")
    private String address;
    private Integer totalNumberofJars;
    private Integer numberofJarsinInventory;
    private Integer numberofCustomers;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date created_At;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updated_At;

    @OneToMany//(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Jar> listofJars = new ArrayList<>();
   /* @OneToMany//(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Partner> listofPartners = new ArrayList<>();*/
    @OneToMany//(fetch = FetchType.EAGER, mappedBy = "user")
    private List<JarTransaction> listofJarTransactions = new ArrayList<>();
    @OneToMany//(fetch = FetchType.EAGER, mappedBy = "user")
    private List<MoneyTransaction> listofMoneyTransactions = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
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

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }
}
