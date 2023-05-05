package it.develhope.shoppyz.entity;

import jakarta.persistence.*;



@Embeddable
public class PaymentMethod {

    private int id;


    public enum Type {
        creditCard,
        paypal
    }
    @Enumerated(EnumType.STRING)
    private Type type;

    private String paymentInformation;

    private int idPayment;

    private int idOrder;


}