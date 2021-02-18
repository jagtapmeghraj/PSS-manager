package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jar {

        @Id
        private Long JarId;
        private Customer Customer;
        private String JarName;
        private User User;
}
