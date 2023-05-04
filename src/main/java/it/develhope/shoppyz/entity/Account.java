package it.develhope.shoppyz.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String enabled;
    @Column(nullable = false, unique = true)
    private String email;

    public Account(Integer id, String name, String surname, String phoneNumber, String enabled, String email/*, List<PaymentMethod> savedPaymentMethods*/) {
        this.id = id;
        this.name = name;
        this.surname = surname;

        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.email = email;

    }

    public Account (){}

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
/*
    public List<PaymentMethod> getSavedPaymentMethods() {
        return savedPaymentMethods;
    }

    public void setSavedPaymentMethods(List<PaymentMethod> savedPaymentMethods) {
        this.savedPaymentMethods = savedPaymentMethods;
    }
    */

}
