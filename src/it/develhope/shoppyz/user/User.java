package it.develhope.shoppyz.user;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.address.Address;

public class User {
    private int id;
    private String name;
    private String surname;
    private String city;
    private Address address;
    private String phoneNumber;
    private Account account;

    public User(int id, String name, String surname, String city, Address address, String phoneNumber, Account account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
