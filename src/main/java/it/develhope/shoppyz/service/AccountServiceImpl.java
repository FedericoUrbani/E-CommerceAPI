package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    /**
     * @return get the account:
     */
    public Optional<Account> getAccount(Integer id) {
        return accountRepository.findById(id);
    }

    /**
     * @return delete the account.
     */
    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }
    /**
     * @return save the account.
     */
    @Override
    public void saveAccount(Account account) {
    accountRepository.save(account);
    }
    /**
     * @return update the user with the id of.
     */
    @Override
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }

    /**
     * @return returns the list of accounts
     */

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }
}
