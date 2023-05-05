package it.develhope.shoppyz.entity;

import jakarta.persistence.*;



@Embeddable
public class PaymentMethod {



    public enum Type {
        creditCard,
        paypal
    }
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = true)
    private String paymentInformation;

    public PaymentMethod(){}

    public PaymentMethod(Type type, String paymentInformation) {

        this.type = type;
        this.paymentInformation = paymentInformation;
    }




    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}