package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partner {

    @Id
    private long PartnerId;
    private long UserId;
    private String Name;
    private int Contact;

}
