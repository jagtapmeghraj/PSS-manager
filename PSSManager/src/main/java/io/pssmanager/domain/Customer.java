package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {

    @Id
    private Long CustomerId;
    private String Name;
    private Integer Contact;
    private String Address;
    @ManyToOne
    private User User ;
    @OneToMany
    private List<Jar> ListofJars;
    @OneToMany
    private List<JarTransaction> ListofJarTransactions;
    @OneToMany
    private List<MoneyTransaction> ListofMoneyTransactions;
    private Integer DueAmount;
    private Integer PricePerJar;



}
