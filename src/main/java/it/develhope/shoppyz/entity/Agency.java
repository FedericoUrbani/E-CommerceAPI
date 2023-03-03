package it.develhope.shoppyz.entity;

import it.develhope.shoppyz.entity.Address;

public class Agency {
    private Address address;
    private String name;
    private String email;
    private String phoneNumber;

    public Agency(Address address, String name, String email, String phoneNumber){
        this.address = address;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Address getAddress(){
        return address;
    }
    public void setAddress(Address address){
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
