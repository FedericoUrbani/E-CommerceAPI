package it.develhope.shoppyz.entity;


import java.util.Random;

public enum PaymentType {
        creditCard,
        paypal;

    private static final Random RNGState = new Random();
    public static PaymentType randomPayment()  {
        PaymentType[] paymentTypes = values();
        return paymentTypes[RNGState.nextInt(paymentTypes.length)];

    }
}
