package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Account;

import java.util.List;

public class AccountRepositoryImpl implements AccountRepository{
    @Override
    public Account getAccount(int id) {
        //get account where id is equal to (get)
        return null;
    }

    @Override
    public void deleteAccount(int id) {
        //delete account where id is equal to (delete)
    }

    @Override
    public void saveAccount(Account account) {
        //save this account in the database (post)
    }

    @Override
    public void updateAccount(int id) {
        //modify the account (put)
    }

    @Override
    public List<Account> getAccounts(List<Account> account) {
        //gets a list of all accounts in the db
        return null;
    }
}
