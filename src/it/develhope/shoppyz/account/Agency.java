package it.develhope.shoppyz.account;

import it.develhope.shoppyz.address.Address;

public class Agency {
    private Address address = new Address();
    private String name;
    private String email;
    private String phoneNumber;
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

}
