package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jar {

        @Id
        private Long JarId;
        @ManyToOne
        private Customer Customer;
        private String JarName;
        @ManyToOne
        private User User;
}
