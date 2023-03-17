package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    String url = "jdbc:mysql://localhost:3306/shoppyzdb";
    String clientUser = "root";
    String password = "root";

    @Override
    public User getUser(int id) {
        User user = null;
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM users WHERE id = '" + id + "'");
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    @Override
    public void deleteUser(int id) {

        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM users WHERE id = '" + id + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser (User user){
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO users " +
                    "(phoneNumber, accountId, name, surname,address) " +
                    "VALUE ('" + user.getName() +
                    "','" + user.getAccountId() +
                    "','" + user.getName() +
                    "','" + user.getSurname() +
                    "','" + user.getAddress() + "');");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(int id, User user) {

        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            stmt.execute("UPDATE users (phoneNumber, accountId, name, surname,address) VALUE ('" + user.getName() +
                    "','" + user.getAccountId() +
                            "','" + user.getName() +
                            "','" + user.getSurname() +
                            "','" + user.getAddress() + "');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsers(List<User> account) {
        ArrayList<User> userList = new ArrayList<>();
        User user = null;
        try {
            conn = DriverManager.getConnection(url, clientUser, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM users;");
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                String phonenumber=resultSet.getString(2);
                int accountId= resultSet.getInt(3);
                String name=resultSet.getString(4);
                String surname=resultSet.getString(5);
                String address=resultSet.getString(6);
                user = new User(id,name,surname,address,phonenumber,accountId);
                userList.add(user);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }



}
