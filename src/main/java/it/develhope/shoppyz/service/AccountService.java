package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;

import java.util.List;

public interface AccountService {
    public void saveAccount(Account account);
    public void deleteAccount(int id);
   public void sellsActivation(int id);

    public void disableAccount(int id);

    public void enableAccount(int id);

    List<Account> listedAccounts();
}
