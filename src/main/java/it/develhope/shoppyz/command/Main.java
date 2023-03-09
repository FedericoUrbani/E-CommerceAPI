package it.develhope.shoppyz.command;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Address;
import it.develhope.shoppyz.payment.CreditCard;
import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /** utilizzate questo main per vedere se nel drivermanager
         * viene settato utente univoco per tutti ed una password univoca
         * nel file Init.sql trovate il file da cui copiare il path
         * runnatelo nella shell di mysql e dovreste avere lo user comune.
         */
        Connection connection = null;
        ArrayList<User> usersList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppyzdb", "developer", "developer1");
            System.out.println(connection != null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Account account= null;
        Statement statement = null;
        ResultSet resultSet = null;
        int id = 1;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM accounts WHERE id= '"+id+"'");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        try {
            while (resultSet.next()) {
                account = new Account(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4),
                        resultSet.getByte(5),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(account);


    }
    }

        /*    // create first user
        Address address1= new Address("via leornardo da vinci","palermo","italy","90145");
        User user1=new User(1999,"Gabri","casti",address1,"3333333","gabri@gmail.com");
        Account account1= new Account(1999,user1,"Gabri0801","19990801G");

        //create first credit card
        CreditCard creditCard1=new CreditCard("11111111111","Gabri casti",111,"01/24");

        //create first product
        Product product1=new Product("0000","food",10.00,"jpg.snackCheese","100");
        product1.setStockedAmount("100");
*/