package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    public void savePaymentMethod(PaymentMethod paymentMethod);

    public void deletePaymentMethod(String Method);

    public void disablePaymentMethod(String Method);

    public void enablePaymentMethod(String Method);

    List<PaymentMethod> listedPaymentMethod();
}
