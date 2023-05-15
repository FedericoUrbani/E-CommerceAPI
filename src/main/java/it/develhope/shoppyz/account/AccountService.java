package it.develhope.shoppyz.account;

import it.develhope.shoppyz.account.Account;


import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Optional<Account> getAccount(Integer id);
    public void deleteAccount(Account account);
    public void deleteById(Integer id);
    public void saveAccount(Account account);
    public void updateAccount(Account account);
    public List<Account> getAccountList();

}
