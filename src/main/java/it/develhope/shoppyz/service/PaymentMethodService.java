package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.PaymentMethod;

import java.sql.SQLException;
import java.util.List;

public interface PaymentMethodService {
    public void savePm(PaymentMethod paymentMethod) throws SQLException;

    public int findPm(int idPayment) throws SQLException;
    public void deletePm(int idPayment) throws SQLException;


}
