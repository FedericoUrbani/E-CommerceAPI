package it.develhope.shoppyz.relationProdCart;

import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.*;

@Entity
public class Cart_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Cart_Product(Long id, Cart cart, Product product) {
        this.id = id;
        this.cart = cart;
        this.product = product;
    }
    public Cart_Product(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    public Cart_Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
