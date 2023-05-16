package it.develhope.shoppyz.facts;

import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.*;

@Entity
public class Cart_product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;



}
