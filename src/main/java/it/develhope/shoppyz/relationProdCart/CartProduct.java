package it.develhope.shoppyz.relationProdCart;

import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.*;

@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cartid;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productid;


    public CartProduct(Long id, Cart cartid, Product productid) {
        this.id = id;
        this.cartid = cartid;
        this.productid = productid;
    }

    CartProduct(){}

    public CartProduct(Cart cartid, Product productid) {

        this.cartid = cartid;
        this.productid = productid;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCartid() {
        return cartid;
    }

    public void setCartid(Cart cartid) {
        this.cartid = cartid;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }
}
