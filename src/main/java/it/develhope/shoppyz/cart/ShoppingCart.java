package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.payment.PaymentMethod;
import it.develhope.shoppyz.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Product product;
    private double totalPrice;
    private PaymentMethod paymentMethod;
    private int currentQuantity;

    List<Product> productList = new ArrayList<>();
    List<Integer> quantities = new ArrayList<>();


    public ShoppingCart(Product product, double totalPrice, PaymentMethod paymentMethod) {
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
        if(!productList.contains(product)){
            productList.add(product);
            quantities.add(quantity);
        }else{
            int index = productList.indexOf(product);
            quantities.set(index, quantities.get(index) + quantity);
        }
    }

    public void printItems(){
        System.out.println("Products in the cart: ");
        for(int i = 0; i < productList.size(); i++){
            System.out.println(productList.get(i).getId() + " - " + productList.get(i).getPrice() + " x " + quantities.get(i));
        }
    }

    public double totalPrice(){
        double totalPrice = 0;
        for(int i = 0; i < productList.size(); i++){
            totalPrice+=productList.get(i).getPrice() * quantities.get(i);
        }
        return totalPrice;
    }
}
