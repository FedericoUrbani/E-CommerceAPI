package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;


import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Optional<Account> getAccount(Integer id);
    public void deleteAccount(Account account);
    public void saveAccount(Account account);
    void updateAccount(Account account);
    public List<Account> getAccountList();

}
