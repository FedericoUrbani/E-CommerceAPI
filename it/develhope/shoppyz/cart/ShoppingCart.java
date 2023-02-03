package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.payment.PaymentMethod;
import it.develhope.shoppyz.product.Product;

public class ShoppingCart {
    private Product product;
    private double totalPrice;
    private PaymentMethod paymentMethod;

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


}
