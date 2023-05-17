package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.relationProdCart.Cart_Product;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart")
    Set<Cart_Product> registrations;

    @Column
    private byte isgift;

    public Cart(Account account, Set<Cart_Product> registrations, byte isgift) {


        this.registrations = registrations;
        this.isgift = isgift;
    }

    public Cart(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Cart_Product> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Cart_Product> registrations) {
        this.registrations = registrations;
    }

    public byte getIsgift() {
        return isgift;
    }

    public void setIsgift(byte isgift) {
        this.isgift = isgift;
    }
}