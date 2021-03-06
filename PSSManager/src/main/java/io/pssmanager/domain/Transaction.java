package io.pssmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Specify jars given")
    private Integer NoOfJarsGiven;

    @NotNull(message = "Specify jars taken")
    private Integer NoOfJarsTaken;

    @NotNull(message = "Specify amount received")
    private Integer AmountReceived;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
   /* @ManyToOne
    private Partner partner;*/

    private Date date;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNoOfJarsGiven() {
        return NoOfJarsGiven;
    }

    public void setNoOfJarsGiven(Integer noOfJarsGiven) {
        NoOfJarsGiven = noOfJarsGiven;
    }

    public Integer getNoOfJarsTaken() {
        return NoOfJarsTaken;
    }

    public void setNoOfJarsTaken(Integer noOfJarsTaken) {
        NoOfJarsTaken = noOfJarsTaken;
    }

    public Integer getAmountReceived() {
        return AmountReceived;
    }

    public void setAmountReceived(Integer amountReceived) {
        AmountReceived = amountReceived;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @PrePersist
    protected void onCreate(){
        this.date = new Date();
    }


}
