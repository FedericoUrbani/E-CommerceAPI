package it.develhope.shoppyz.payment;

public class PaymentMethod {
    private Paypal paypal;
    private CreditCard creditCard;
    private Coupon coupon;
    private CashOnDelivery cashOnDelivery;

    public Paypal getPaypal() {
        return paypal;
    }

    public void setPaypal(Paypal paypal) {
        this.paypal = paypal;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public CashOnDelivery getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(CashOnDelivery cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }
}
