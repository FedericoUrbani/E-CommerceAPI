package it.develhope.shoppyz.cartitem;

import it.develhope.shoppyz.order.OrderProduct;

import java.util.List;

public class CartItemDTO {


    private String name;
    private String surname;
    private double totalprice;
    List<OrderProduct> productInCart;

    public CartItemDTO(double totalprice, String name, String surname, List<OrderProduct> productInCart) {
        this.totalprice = totalprice;
        this.name = name;
        this.surname = surname;
        this.productInCart = productInCart;
    }
    public CartItemDTO(){}
    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
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

    public List<OrderProduct> getProductInCart() {
        return productInCart;
    }

    public void setProductInCart(List<OrderProduct> productInCart) {
        this.productInCart = productInCart;
    }
}
