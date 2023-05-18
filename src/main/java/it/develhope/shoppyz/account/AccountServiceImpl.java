package it.develhope.shoppyz.account;


import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.cart.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CartRepository cartRepository;





    /**
     * @return get the account:
     */
    public Optional<Account> getAccount(Long id) {
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
    public Account saveAccount(Account account) {
    accountRepository.save(account);
    return account;
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

    public void deleteById(Long id){accountRepository.deleteById(id);}



    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
