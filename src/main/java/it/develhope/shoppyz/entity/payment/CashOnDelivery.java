package it.develhope.shoppyz.entity.payment;

import it.develhope.shoppyz.entity.PaymentMethod;

public class CashOnDelivery extends PaymentMethod {

    private double amount;

    public CashOnDelivery(double amount) {
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


    public void processPayment() {
        System.out.println("Processing cash on delivery payment of euro:" + amount);
    }
}
