package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.repository.AccountRepository;
import it.develhope.shoppyz.repository.AccountRepositoryImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository= new AccountRepositoryImpl();

    public Account getAccount(int id) {
        return accountRepository.getAccount(id);
    }


    public void deleteAccount(int id) {
        accountRepository.deleteAccount(id);
    }


    public void saveAccount(Account account) {
        accountRepository.saveAccount(account);
    }


    public void updateAccount(int id, Account account) {
        accountRepository.updateAccount(id,account);
    }

    @Override
    public void sellsActivation(int id) {
        if (accountRepository.getAccount(id).getSellsAccountActivation() == false) {
            accountRepository.getAccount(id).setSellsAccountActivation(true);
        } else {
            System.out.println("Account sells is already active");
        }
    }

    @Override
    public void disableAccount(int id) {
        accountRepository.getAccount(id).setEnabledAccount(false);

    }

    @Override
    public void enableAccount(int id) {
        accountRepository.getAccount(id).setEnabledAccount(true);
    }

    @Override
    public void doubleAuthenticationEnable(int id) {
       accountRepository.getAccount(id).setDoubleAuthentication(true);
       accountRepository.getAccount(id).setAuthenticatedPhoneNumber(accountRepository.getAccount(id).getUser().getPhoneNumber());

    }

    @Override
    public List<Account> listedAccounts(List<Account> list) {
            accountRepository.getAccounts(list);
        return null;
    }



}
