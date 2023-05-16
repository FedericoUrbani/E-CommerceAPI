package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.account.Address;
import it.develhope.shoppyz.facts.Cart_product;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "account_id")
    private int id;


    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "cart")
    Set<Cart_product> registrations;

    @Column
    private byte isgift;

    public Cart(int id, Account account, List<Product> cartProductList, byte isgift) {
        this.id = id;
        this.account = account;
        this.isgift = isgift;
    }

    public Cart() {
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public byte getIsgift() {
        return isgift;
    }

    public void setIsgift(byte isgift) {
        this.isgift = isgift;
    }

}