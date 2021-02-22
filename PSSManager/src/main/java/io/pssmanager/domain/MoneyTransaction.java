package io.pssmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class MoneyTransaction {

    @Id
    private Long id;
    @NotNull(message = "Specify the customer")
    @ManyToOne
    private Customer Customer;
    @ManyToOne
    private User User;
   /* @ManyToOne
    private Partner Partner;*/
    @NotNull(message = "Specify the amount")
    private Integer AmountReceived;
    private Date date;

    public MoneyTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public io.pssmanager.domain.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(io.pssmanager.domain.Customer customer) {
        Customer = customer;
    }

    public io.pssmanager.domain.User getUser() {
        return User;
    }

    public void setUser(io.pssmanager.domain.User user) {
        User = user;
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

    @PreUpdate
    protected void onUpdate(){
        this.date = new Date();
    }
}
