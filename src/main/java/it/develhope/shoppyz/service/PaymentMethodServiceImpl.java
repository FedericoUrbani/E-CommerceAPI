package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.PaymentMethod;
import it.develhope.shoppyz.entity.payment.Paypal;
import it.develhope.shoppyz.repository.PaymentMethodRepository;
import it.develhope.shoppyz.repository.PaymentMethodRepositorylmpl;

import java.lang.reflect.Method;
import java.util.List;

public class PaymentMethodServiceImpl implements PaymentMethodService {

    PaymentMethodRepository paymentMethodRepository= new PaymentMethodRepositorylmpl();

    public PaymentMethod getPaymentMethod(String Method) {
        return paymentMethodRepository.getPaymentMethod(Method);
    }


    public void savePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodRepository.savePaymentMethod(paymentMethod);
    }

    @Override
    public void deletePaymentMethod(String Method) {
        paymentMethodRepository.deletePaymentMethod(Method);
    }

    @Override
    public void disablePaymentMethod(String Method) {

    }

    @Override
    public void enablePaymentMethod(String Method) {

    }

    public void updatePaymentMethod(String Method,PaymentMethod paymentMethod) {
        paymentMethodRepository.updatePaymentMethod(Method,paymentMethod);
    }

    @Override
    public List<PaymentMethod> listedPaymentMethod() {
        List<PaymentMethod> paymentMethodList= paymentMethodRepository.getPaymentMethod();
        return paymentMethodList;
    }
}
