package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToMany(mappedBy = "cart", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Product> productsInCart = new ArrayList<>();

    @Column
    private byte isgift;

    public Cart() {
    }

    public Cart(int id, Account account, List<Product> productsInCart, byte isgift) {
        this.id = id;
        this.account = account;
        this.productsInCart = productsInCart;
        this.isgift = isgift;
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

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public byte getIsgift() {
        return isgift;
    }

    public void setIsgift(byte isgift) {
        this.isgift = isgift;
    }

}