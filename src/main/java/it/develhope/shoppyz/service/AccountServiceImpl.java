package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.repository.AccountRepository;
import it.develhope.shoppyz.repository.AccountRepositoryImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository= new AccountRepositoryImpl();

    /**
     * @return Get the account with the id of:
     */
    public Account getAccount(int id) {
        return accountRepository.getAccount(id);
    }

    /**
     * @return Delete the account with the id of
     */
    public void deleteAccount(int id) {
        accountRepository.deleteAccount(id);
    }

    /**
     * @return Save the account obj in the db
     */
    public void saveAccount(Account account) {
        accountRepository.saveAccount(account);
    }

    /**
     * @return Update de account used in the params with the id of:
     */
    public void updateAccount(int id, Account account) {
        accountRepository.updateAccount(id,account);
    }
    /**
     * @return Activate sells operations for account with the id of:
     */
    @Override
    public void sellsActivation(int id) {
        Account account= accountRepository.getAccount(id);
        account.setSellsactivation((byte) 1);
        updateAccount(id,account);
    }
    /**
     * @return Disable the account with the id of:
     */
    @Override
    public void disableAccount(int id) {
        Account account= accountRepository.getAccount(id);
        account.setEnabled((byte) 0);
        updateAccount(id,account);
    }
    /**
     * @return Calling this method will enable the account with the id of.
     */
    @Override
    public void enableAccount(int id) {
        Account account= accountRepository.getAccount(id);
        account.setEnabled((byte) 1);
        updateAccount(id,account);
    }


    /**
     * @return A list of Accounts from db
     */
    @Override
    public List<Account> listedAccounts() {
        List<Account> list= accountRepository.getAccounts();
        return list;
    }



}
