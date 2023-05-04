package it.develhope.shoppyz.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;


@Entity
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    public enum Type {
        creditCard,
        paypal
    }
    @Enumerated(EnumType.STRING)
    @Column
    private Type type;
    @Column
    private String paymentInformation;
    @Column
    private int idPayment;
    @Column
    private int idOrder;


}