package it.develhope.shoppyz.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "account_addresses", joinColumns = @JoinColumn(name="account_id"), foreignKey = @ForeignKey(name = "addresses_account_fk"))
    private Map<Integer,Address> addresses;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String enabled;
    @Column(nullable = false, unique = true)
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "account_paymentmethods", joinColumns = @JoinColumn(name="account_id"), foreignKey = @ForeignKey(name = "paymentmethods_account_fk"))
    private Map<Integer,PaymentMethod> paymentMethods;

    public Account(Integer id, String name, String surname, Map<Integer,Address> addresses, String phoneNumber, String enabled, String email, Map<Integer,PaymentMethod> paymentMethods) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.addresses = addresses;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.email = email;
        this.paymentMethods = paymentMethods;
    }

    public Account(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<Integer,Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<Integer,Address> addresses) {
        this.addresses = addresses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Integer,PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Map<Integer,PaymentMethod> paymentMethods) {
        this.paymentMethods =  paymentMethods;
    }
}
