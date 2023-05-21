package it.develhope.shoppyz.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderProduct {

    @Column
    private String name;
    @Column
    private double price;

    public OrderProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public OrderProduct(){}

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
