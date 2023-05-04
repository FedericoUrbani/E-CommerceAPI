package it.develhope.shoppyz.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    @OneToMany
    private List<Address> address;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String enabled;
    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = true)
    @OneToMany
    private List<PaymentMethod> savedPaymentMethods;

    public Account(Integer id, String name, String surname, List<Address> address, String phoneNumber, String enabled, String email, List<PaymentMethod> savedPaymentMethods) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.email = email;
        this.savedPaymentMethods = savedPaymentMethods;
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
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

    public List<PaymentMethod> getSavedPaymentMethods() {
        return savedPaymentMethods;
    }

    public void setSavedPaymentMethods(List<PaymentMethod> savedPaymentMethods) {
        this.savedPaymentMethods = savedPaymentMethods;
    }
}
