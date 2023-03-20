package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.PaymentMethod;
import it.develhope.shoppyz.entity.payment.CashOnDelivery;
import it.develhope.shoppyz.entity.payment.Coupon;
import it.develhope.shoppyz.entity.payment.CreditCard;
import it.develhope.shoppyz.entity.payment.Paypal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodRepositorylmpl implements PaymentMethodRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    String url = "jdbc:mysql://localhost:3306/shoppyzdb";
    String user = "root";
    String password = "root";




    @Override
    public PaymentMethod getPaymentMethod(String Method) {
        //Get payment Method
        PaymentMethod paymentMethod = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM payment_methods WHERE Method = '" + Method + "'");
            while (resultSet.next()) {
                String paymentMethodType = resultSet.getString(1);
                if (paymentMethodType.equals("Paypal")) {
                    String email = resultSet.getString(2);
                    String paypalPassword = resultSet.getString(3);
                    paymentMethod = new Paypal(email, paypalPassword);

                } else if (paymentMethodType.equals("CashOnDelivery")) {
                    //other payment method types here
                    double amount = resultSet.getDouble(4);
                    paymentMethod = new CashOnDelivery(amount);

                } else if (paymentMethodType.equals("Coupon")) {
                    String couponCode = resultSet.getString(4);
                    double discount = resultSet.getDouble(5);
                    paymentMethod = new Coupon(couponCode, discount);

                }else if (paymentMethodType.equals("CreditCard")) {
                    String cardNumber = resultSet.getString(4);
                    String cardHolder = resultSet.getString(5);
                    int securityCodeCCV = resultSet.getInt(6);
                    String expirationDate = resultSet.getString(7);
                    paymentMethod = new CreditCard(cardNumber,cardHolder,securityCodeCCV,expirationDate);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentMethod;


}

    @Override
    public void deletePaymentMethod(String Method) {
        //delete account where method is equal to (delete)
        PaymentMethod paymentMethod = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM payment_methods WHERE Method = " + Method + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public void savePaymentMethod(PaymentMethod paymentMethod) {
        //save this PaymentMethod in the database
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            if (paymentMethod instanceof Paypal) {
                Paypal paypal = (Paypal) paymentMethod;
                String email = paypal.getEmail();
                String password= paypal.getPassword();
                // Inserire l'indirizzo email e password di Paypal nella query di inserimento
                stmt.execute("INSERT INTO payment_methods(email,password) VALUES ('" + email + "','"+ password+"');");
            } else if (paymentMethod instanceof CashOnDelivery){
                CashOnDelivery cashOnDelivery=(CashOnDelivery) paymentMethod;
                Double amount = cashOnDelivery.getAmount();
                // Inserire l'amount di cashOnDelivery nella query di inserimento
                stmt.execute("INSERT INTO payment_methods(amount) VALUES (" +amount+"');");
            } else if (paymentMethod instanceof Coupon ) {
                Coupon coupon=(Coupon) paymentMethod;
                String couponCode= coupon.getCouponCode();
                double discount = coupon.getDiscount();
                stmt.execute("INSERT INTO payment_methods(couponCode,discount) VALUES ('" + couponCode + "','"+ discount+"');");

            } else if (paymentMethod instanceof CreditCard) {
                CreditCard creditCard= (CreditCard) paymentMethod;
                String cardNumber=creditCard.getCardNumber();
                String cardHolder= creditCard.getCardHolder();
                int securityCodeCCV= creditCard.getSecurityCodeCCV();
                String expirationDate= creditCard.getExpirationDate();
                stmt.execute("INSERT INTO payment_methods(cardNumber,cardHolder,securityCodeCCV,expirationDate) VALUES ('" + cardNumber + "','"+ cardHolder+"','"+ securityCodeCCV+"','"+ expirationDate+"');");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updatePaymentMethod(String Method, PaymentMethod paymentMethod) {
        //update PaymentMethod
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            if (paymentMethod instanceof Paypal) {
                Paypal paypal = (Paypal) paymentMethod;
                String email = paypal.getEmail();
                String password= paypal.getPassword();
                // Inserire l'indirizzo email e password di Paypal nella query di inserimento
                stmt.execute("UPDATE payment_methods(email,password) VALUES ('" + email + "','"+ password+"')WHERE Method ="+Method+";");
            } else if (paymentMethod instanceof CashOnDelivery){
                CashOnDelivery cashOnDelivery=(CashOnDelivery) paymentMethod;
                Double amount = cashOnDelivery.getAmount();
                // Inserire l'amount di cashOnDelivery nella query di inserimento
                stmt.execute("UPDATE payment_methods(amount) VALUES (" +amount+"');WHERE Method ="+Method+";");
            } else if (paymentMethod instanceof Coupon ) {
                Coupon coupon=(Coupon) paymentMethod;
                String couponCode= coupon.getCouponCode();
                double discount = coupon.getDiscount();
                stmt.execute("UPDATE payment_methods(couponCode,discount) VALUES ('" + couponCode + "','"+ discount+"')WHERE Method ="+Method+";");

            } else if (paymentMethod instanceof CreditCard) {
                CreditCard creditCard= (CreditCard) paymentMethod;
                String cardNumber=creditCard.getCardNumber();
                String cardHolder= creditCard.getCardHolder();
                int securityCodeCCV= creditCard.getSecurityCodeCCV();
                String expirationDate= creditCard.getExpirationDate();
                stmt.execute("UPDATE payment_methods(cardNumber,cardHolder,securityCodeCCV,expirationDate) VALUES ('" + cardNumber + "','"+ cardHolder+"','"+ securityCodeCCV+"','"+ expirationDate+"')WHERE Method ="+Method+";");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public List<PaymentMethod> getPaymentMethod() {
        ArrayList<PaymentMethod> paymentMethodList= new ArrayList<>();
        PaymentMethod paymentMethod=null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM payment_methods;");
            while (resultSet.next()) {
                String paymentMethodType = resultSet.getString(1);
                if (paymentMethodType.equals("Paypal")) {
                    String email = resultSet.getString(2);
                    String paypalPassword = resultSet.getString(3);
                    paymentMethod = new Paypal(email, paypalPassword);
                    paymentMethodList.add(paymentMethod);
                } else if (paymentMethodType.equals("CashOnDelivery")) {
                    //other payment method types here
                    double amount = resultSet.getDouble(4);
                    paymentMethod = new CashOnDelivery(amount);
                    paymentMethodList.add(paymentMethod);

                } else if (paymentMethodType.equals("Coupon")) {
                    String couponCode = resultSet.getString(4);
                    double discount = resultSet.getDouble(5);
                    paymentMethod = new Coupon(couponCode, discount);
                    paymentMethodList.add(paymentMethod);

                }else if (paymentMethodType.equals("CreditCard")) {
                    String cardNumber = resultSet.getString(4);
                    String cardHolder = resultSet.getString(5);
                    int securityCodeCCV = resultSet.getInt(6);
                    String expirationDate = resultSet.getString(7);
                    paymentMethod = new CreditCard(cardNumber,cardHolder,securityCodeCCV,expirationDate);
                    paymentMethodList.add(paymentMethod);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentMethodList;
    }
}
