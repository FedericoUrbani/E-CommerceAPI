package it.develhope.shoppyz.repository;
import it.develhope.shoppyz.entity.PaymentMethod;

import java.sql.SQLException;

public interface PaymentMethodRepository {
    public void savePm(PaymentMethod paymentMethod) throws SQLException;

    public PaymentMethod findPm(int idPayment) throws SQLException;

    public void deletePm(int idPayment) throws SQLException;
}

