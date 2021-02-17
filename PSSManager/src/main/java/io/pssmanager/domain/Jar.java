package io.pssmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jar {

        @Id
        private long JarId;
        private long CustomerId;
        private String JarName;
        private long UserId;
}
