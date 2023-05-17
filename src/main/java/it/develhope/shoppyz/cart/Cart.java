package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.account.Address;
import it.develhope.shoppyz.facts.Cart_product;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "cart")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "cart")
    Set<Cart_product> registrations;

    @Column
    private byte isgift;

    public Cart(Account account, Set<Cart_product> registrations, byte isgift) {


        this.registrations = registrations;
        this.isgift = isgift;
    }

    public Cart (){}



    public Set<Cart_product> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Cart_product> registrations) {
        this.registrations = registrations;
    }

    public byte getIsgift() {
        return isgift;
    }

    public void setIsgift(byte isgift) {
        this.isgift = isgift;
    }
}