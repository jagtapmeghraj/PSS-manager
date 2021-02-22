package io.pssmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class JarTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Specify the Jar")
    @OneToOne
    private Jar jar;
    @NotNull(message = "Specify the Customer")
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private User user;
   /* @ManyToOne
    private Partner partner;*/
    @NotBlank(message = "Specify Action")
    private String action; //is jar "GIVEN" to or "TAKEN" from customer?
    private Date date;

    public JarTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jar getJar() {
        return jar;
    }

    public void setJar(Jar jar) {
        this.jar = jar;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
