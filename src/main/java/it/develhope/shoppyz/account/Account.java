package it.develhope.shoppyz.account;

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
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "account_addresses", joinColumns = @JoinColumn(name="account_id"), foreignKey = @ForeignKey(name = "addresses_account_fk"))
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "state", column = @Column(name = "state")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "PostalCode")),
    })
    private List<Address> addresses;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private byte enabled;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "account_payments", joinColumns = @JoinColumn(name="account_id"), foreignKey = @ForeignKey(name = "payment_account_fk"))
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "card_type")),
            @AttributeOverride(name = "paymentInformation", column = @Column(name = "payment_info")),
    })
    private List<PaymentMethod> paymentMethods;
    public Account(){}

    public Account(Integer id, String name, String surname, List<Address> addresses, String phoneNumber, byte enabled, String email, String password, List<PaymentMethod> paymentMethods) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.addresses = addresses;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.email = email;
        this.password = password;
        this.paymentMethods = paymentMethods;
    }

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
