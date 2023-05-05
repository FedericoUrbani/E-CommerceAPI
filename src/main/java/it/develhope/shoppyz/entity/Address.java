package it.develhope.shoppyz.entity;

import jakarta.persistence.*;

@Embeddable
public class Address {


    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String postalCode;

    public Address(){}

    public Address( String street, String city, String state, String postalCode) {

        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }





    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
