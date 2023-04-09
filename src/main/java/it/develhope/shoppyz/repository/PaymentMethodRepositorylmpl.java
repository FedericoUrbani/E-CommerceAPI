package it.develhope.shoppyz.repository;
import it.develhope.shoppyz.entity.PaymentMethod;


import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodRepositorylmpl implements PaymentMethodRepository {

    String url = "jdbc:mysql://localhost:3306/shoppyzdb";
    String user = "root";
    String password = "root";

    @Override
    public void savePm(PaymentMethod paymentMethod) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO paymentMethod (type, paymentInformation, idOrder) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            //associare l'ID del pagamento appena creato all'oggetto PaymentMethod.

            stmt.setString(1, paymentMethod.getType().name());
            stmt.setString(2, paymentMethod.getPaymentInformation());
            stmt.setInt(3, paymentMethod.getIdOrder());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                paymentMethod.setIdPayment(rs.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            stmt.close();
            conn.close();
        }


    }

    @Override
    public PaymentMethod findPm(int idPayment) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PaymentMethod paymentMethod = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM paymentMethod WHERE paymentInformation = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idPayment);
            rs = stmt.executeQuery();

            if (rs.next()) {
                PaymentMethod.Type type = PaymentMethod.Type.valueOf(rs.getString("type"));
                String paymentInformation = rs.getString("paymentInformation");
                int idOrder = rs.getInt("idOrder");

                paymentMethod = new PaymentMethod(type, paymentInformation, idOrder);
                paymentMethod.setIdPayment(idPayment);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            stmt.close();
            conn.close();
        }


        return paymentMethod;

    }


    public void deletePm(int idPayment) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM paymentMethod WHERE idPayment = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idPayment);
            stmt.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            stmt.close();
            conn.close();

        }


    }
}


