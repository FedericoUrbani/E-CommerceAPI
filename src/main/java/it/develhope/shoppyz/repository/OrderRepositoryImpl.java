package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OrderRepositoryImpl implements OrderRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    String url = "jdbc:mysql://localhost:3306/shoppyzdb";
    String user = "root";
    String password = "root";


    @Override
    public Order getOrder(int id) {
        //prendere un order
        Order order = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM Orders WHERE id = '" + id + "'");
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getInt(6)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        //delete order where id is equal to. (delete)
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM Orders WHERE id = " + id + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   /* @Override
    public void saveOrder(Order order, int userId){
        //save this order in the database (post)
        User buyer = userRepository.getUser(userId);
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO Orders (userId, trackingNumber, numberOfItems, address,isGift) VALUE ('"+buyer.getId()+"','"+order.getTrackingNumber()+"','"+order.getNumberOfItems()+"','"+order.getAddress()+"','"+order.getIsgift()+"');");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public void updateOrder(int id, Order order) {
        //modify the order (put)

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.execute("UPDATE Orders (userId, trackingNumber, numberOfItems, address,isGift) VALUE ('"+order.getUserId()+"','"+order.getTrackingNumber()+"','"+order.getNumberOfItems()+"','"+order.getAddress()+"','"+order.getIsgift()+"') WHERE id ="+id+";");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getOrders() {
        //gets a list of all orders in the db
        ArrayList<Order> orderList = new ArrayList<>();
        Order order= null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM Orders;");
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                int userId=resultSet.getInt(2);
                String trackingNumber= resultSet.getString(3);
                int numberOfItems=resultSet.getInt(4);
                String address=resultSet.getString(5);
                int isGift=resultSet.getByte(5);
                order = new Order(id,userId,trackingNumber,numberOfItems,address,isGift);
                orderList.add(order);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

}
