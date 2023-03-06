package it.develhope.shoppyz.payment;

import it.develhope.shoppyz.entity.PaymentMethod;

public class CreditCard extends PaymentMethod {
    private String cardNumber;
    private String cardHolder;
    private int securityCodeCCV;
    private String expirationDate;

    public CreditCard(String cardNumber, String cardHolder, int securityCodeCCV, String expirationDate){
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.securityCodeCCV = securityCodeCCV;
        this.expirationDate = expirationDate;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getSecurityCodeCCV() {
        return securityCodeCCV;
    }

    public void setSecurityCodeCCV(int securityCodeCCV) {
        this.securityCodeCCV = securityCodeCCV;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
