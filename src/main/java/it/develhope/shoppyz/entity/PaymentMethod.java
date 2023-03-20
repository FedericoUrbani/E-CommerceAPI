package it.develhope.shoppyz.entity;

import it.develhope.shoppyz.entity.payment.CashOnDelivery;
import it.develhope.shoppyz.entity.payment.Coupon;
import it.develhope.shoppyz.entity.payment.CreditCard;
import it.develhope.shoppyz.entity.payment.Paypal;

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


    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paypal=" + paypal +
                ", creditCard=" + creditCard +
                ", coupon=" + coupon +
                ", cashOnDelivery=" + cashOnDelivery +
                '}';
    }
}
