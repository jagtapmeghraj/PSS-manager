package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partner {

    @Id
    private Long PartnerId;
    private User User;
    private String Name;
    private Integer Contact;

}
