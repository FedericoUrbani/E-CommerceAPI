package it.develhope.shoppyz.entity;

public class PaymentMethod {
    public enum Type {
    creditCard,
    paypal
    }
    private Type type;
    private String paymentInformation;
    private int idPayment;
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