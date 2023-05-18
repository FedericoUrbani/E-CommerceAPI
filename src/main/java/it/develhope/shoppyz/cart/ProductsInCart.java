package it.develhope.shoppyz.cart;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductsInCart {

    @Column
    private String name;

    @Column
    private double price;


    public ProductsInCart(String name, double price) {
        this.name = name;
        this.price = price;
    }

    ProductsInCart(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
