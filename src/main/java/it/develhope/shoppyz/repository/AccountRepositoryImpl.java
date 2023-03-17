package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    String url = "jdbc:mysql://localhost:3306/shoppyzdb";
    String user = "root";
    String password = "root";


    @Override
    public Account getAccount(int id) {
        //prendere un account
        Account account = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM accounts WHERE id = '" + id + "'");
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
        return account;
    }


    @Override
    public void deleteAccount(int id) {
        //delete account where id is equal to (delete)
        Account account = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM accounts WHERE id = " + id + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        //save this account in the database (post)
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO accounts (name, password, sellsactivation, isenabled,email) VALUE ('"+account.getName()+"','"+account.getPassword()+"','"+account.getSellsactivation()+"','"+account.getEnabled()+"','"+account.getMail()+"');");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(int id,Account account) {
        //modify the account (put)

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.execute("UPDATE accounts (name, password, sellsactivation, isenabled,email) VALUE ('"+account.getName()+"','"+account.getPassword()+"','"+account.getSellsactivation()+"','"+account.getEnabled()+"','"+account.getMail()+"') WHERE id ="+id+";");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> getAccounts() {
        //gets a list of all accounts in the db
        ArrayList<Account> accountList = new ArrayList<>();
        Account account = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM accounts;");
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String password= resultSet.getString(3);
                byte sellsacc=resultSet.getByte(4);
                byte isenabled=resultSet.getByte(5);
                String email=resultSet.getString(6);
                account = new Account(id,name,password,sellsacc,isenabled,email);
                accountList.add(account);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountList;
    }
}
