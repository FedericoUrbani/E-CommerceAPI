package it.develhope.shoppyz.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;


@Entity
@Table

public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    public enum Type {
    creditCard,
    paypal
    }
    @Enumerated
    @Column
    private Type type;
    @Column
    private String paymentInformation;
    @Column
    private int idPayment;
    @Column
    private int idOrder;

    public PaymentMethod(Type type, String paymentInformation, int idOrder) {
        this.type = type;
        this.paymentInformation = paymentInformation;
        this.idOrder = idOrder;
    }

   public Type getType() {
        return type;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
}