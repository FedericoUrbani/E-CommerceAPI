package it.develhope.shoppyz.payment;

import it.develhope.shoppyz.entity.PaymentMethod;

public class Coupon extends PaymentMethod {
    private String couponCode;
    private double discount;

    public Coupon(String couponCode, double discount){
        this.couponCode = couponCode;
        this.discount = discount;


    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
