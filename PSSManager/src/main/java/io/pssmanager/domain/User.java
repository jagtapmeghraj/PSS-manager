package io.pssmanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
//deviation from tutorial: implemented getpassword method from userdetails.
@Entity
@Table(name = "JAR_USERS")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Username needs to be an email")
    @NotBlank(message = "username is required")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Please enter your full name")
    private String fullName;

    @NotBlank(message = "Password field is required")
    private String password;

    @Transient
    private String confirmPassword;

    @Size(min=10, max=10, message = "Enter valid mobile number")
    @NotBlank(message = "Contact number is required")
    private String userContact;

    @NotBlank(message = "Address is required")
    private String address;
    private Integer totalNumberofJars;
    private Integer numberofJarsinInventory;
    private Integer numberofCustomers;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date created_At;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updated_At;

    //OneToMany with Customer
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

   /* @OneToMany//(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Partner> listofPartners = new ArrayList<>();*/
    @OneToMany//(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Transaction> listofTransactions = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTotalNumberofJars() {
        return totalNumberofJars;
    }

    public void setTotalNumberofJars(Integer totalNumberofJars) {
        this.totalNumberofJars = totalNumberofJars;
    }

    public Integer getNumberofJarsinInventory() {
        return numberofJarsinInventory;
    }

    public void setNumberofJarsinInventory(Integer numberofJarsinInventory) {
        this.numberofJarsinInventory = numberofJarsinInventory;
    }

    public Integer getNumberofCustomers() {
        return numberofCustomers;
    }

    public void setNumberofCustomers(Integer numberofCustomers) {
        this.numberofCustomers = numberofCustomers;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public List<Transaction> getListofTransactions() {
        return listofTransactions;
    }

    public void setListofTransactions(List<Transaction> listofTransactions) {
        this.listofTransactions = listofTransactions;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
