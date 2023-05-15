package it.develhope.shoppyz.account;

import jakarta.persistence.*;


@Embeddable
public class PaymentMethod {

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Column(nullable = true)
    private String paymentInformation;
    public PaymentMethod(){}
    public PaymentMethod(PaymentType type, String paymentInformation) {
        this.type = type;
        this.paymentInformation = paymentInformation;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}