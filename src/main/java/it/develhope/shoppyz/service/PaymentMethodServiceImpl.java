package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.PaymentMethod;
import it.develhope.shoppyz.repository.PaymentMethodRepository;
import it.develhope.shoppyz.repository.PaymentMethodRepositorylmpl;

import java.sql.SQLException;

public class PaymentMethodServiceImpl implements PaymentMethodService {

    PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepositorylmpl();

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public void savePm(PaymentMethod paymentMethod) throws SQLException {
        paymentMethodRepository.savePm(paymentMethod);
    }

    @Override
    public int findPm(int idPayment) throws SQLException {
        paymentMethodRepository.findPm(idPayment);
        return idPayment;
    }

    public void deletePm(int idPayment) throws SQLException {
        paymentMethodRepository.deletePm(idPayment);
    }
}

