package it.develhope.shoppyz.repository;
import it.develhope.shoppyz.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {
    public PaymentMethod getPaymentMethod(String Method);

    public void deletePaymentMethod(String Method);

    public void savePaymentMethod(PaymentMethod paymentMethod);

    public void updatePaymentMethod(String Method, PaymentMethod paymentMethod);

    public List<PaymentMethod> getPaymentMethod();
}

