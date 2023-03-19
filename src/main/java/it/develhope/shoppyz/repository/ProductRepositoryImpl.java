package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ProductRepositoryImpl implements ProductRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    String url = "jdbc:mysql://localhost:3306/shoppyzdb";
    String clientUser = "root";
    String password = "Alemelfi1394";

    @Override
    public Product getProduct(int id) {
        //prendere un prodotto
        Product product = null;
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
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
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO products (name, brand, type, price, stockedAmount) " +
                    "VALUES ('"+product.getName()+"', '"+product.getBrand()+"', '"+product.getType()+"', '"+product.getPrice()+"', '"+product.getStockedAmount()+"');");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(String id, Product product) {
        //modificare un prodotto
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            stmt.execute("UPDATE products (name, brand, type, price, stockedAmount) " +
                    "VALUES ('"+product.getName()+"', '"+product.getBrand()+"', '"+product.getType()+"', '"+product.getPrice()+"', '"+product.getStockedAmount()+"')" +
                    " WHERE id= '"+id+"';");
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(String id) {
        //cancellare un prodotto
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM products WHERE id= '"+id+"';");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProduct() {
        //prende la lista di ogni prodotto nel database
        ArrayList<Product> productList = new ArrayList<>();
        Product product = null;
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM products");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String brand = resultSet.getString(3);
                String type = resultSet.getString(4);
                double price = resultSet.getDouble(5);
                int stockedAmount = resultSet.getInt(6);
                product = new Product(id, name, brand, type, price, stockedAmount);
                productList.add(product);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return productList;
    }
}
