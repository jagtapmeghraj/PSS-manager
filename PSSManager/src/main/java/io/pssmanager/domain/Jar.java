package io.pssmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Jar {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Size(min=6, max=12, message = "Jar identifier length should be 6 to 12")
        @Column(updatable = false, unique = true)
        @NotBlank(message = "Jar identifier is required")
        private String jarName;

        @ManyToOne(fetch = FetchType.EAGER)
        @JsonIgnore
        private Customer customer;
        @ManyToOne
        private User user;

        public Jar() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getJarName() {
                return jarName;
        }

        public void setJarName(String jarName) {
                this.jarName = jarName;
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
}
