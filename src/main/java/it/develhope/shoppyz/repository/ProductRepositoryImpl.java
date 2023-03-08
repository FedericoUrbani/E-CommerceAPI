package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;

import java.sql.*;
import java.util.List;



public class ProductRepositoryImpl implements ProductRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    String url = "jdbc:mysql://localhost:3306/shoppyzdb";
    String user = "root";
    String password = "Alemelfi1394";

    @Override
    public Product getProduct(int id) {
        //prendere un prodotto
        Product product = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM products WHERE id = " + id + ";");
            product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getInt(6));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void postProduct(Product product) {
        //aggiungere un prodotto
    }

    @Override
    public void updateProduct(String id) {
        //modificare un prodotto
    }

    @Override
    public void deleteProduct(String id) {
        //cancellare un prodotto
    }

    @Override
    public List<Product> getProduct(List<Product> products) {
        //prende la lista di ogni prodotto nel database
        return null;
    }
}
