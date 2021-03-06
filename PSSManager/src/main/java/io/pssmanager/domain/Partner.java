package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Partner {

    @Id
    private Long id;
    @ManyToOne
    private User User;
    private String Name;
    private String Contact;
    @OneToMany
    private List<Transaction> ListofTransactions;


}
