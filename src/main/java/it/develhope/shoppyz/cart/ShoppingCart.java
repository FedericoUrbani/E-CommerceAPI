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

    /**
     * Adds a product to the cart with the specified quantity.
     * if the product is already in the shopping cart, the quantity is updated.
     *
     * @param product the product to add to the cart
     * @param quantity the quantity of the product to add
     */
    public void addProduct(Product product, int quantity) {
        for(int i = 0; i < quantity; i++){
            this.productList.add(product);
        }
    }
}