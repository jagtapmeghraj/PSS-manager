package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jar {

        @Id
        private Long id;
        @ManyToOne
        private Customer Customer;
        private String JarName;
        @ManyToOne
        private User User;
}
