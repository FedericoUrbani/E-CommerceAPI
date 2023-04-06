package it.develhope.shoppyz.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Product product;
    private double totalPrice;
    private PaymentMethod paymentMethod;


    List<Product> productList = new ArrayList<>();
    List<Integer> quantities = new ArrayList<>();


    public Cart(Product product, double totalPrice, PaymentMethod paymentMethod) {
        this.product = product;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addProduct(Product product, int quantity) {
        if (!productList.contains(product)) {
            productList.add(product);
            quantities.add(quantity);
        } else {
            int index = productList.indexOf(product);
            quantities.set(index, quantities.get(index) + quantity);
        }
    }

    public void printItems() {
        System.out.println("Products in the cart: ");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getId() + " - " + productList.get(i).getPrice() + " x " + quantities.get(i));
        }
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < productList.size(); i++) {
            totalPrice += productList.get(i).getPrice() * quantities.get(i);
        }
        return totalPrice;
    }

    public void removedProduct(Product product, int quantity){
        int index = productList.indexOf(product);
        if(index != -1){
            int currentQuantity = quantities.get(index);
            if(currentQuantity > quantity){
                quantities.set(index, currentQuantity - quantity);
            } else {
                productList.remove(index);
                quantities.remove(index);
            }
            System.out.println(quantity + " " + product.getId() + " removed from cart.");
        }else {
            System.out.println(product.getId() + " not found in cart");
        }
    }
}
