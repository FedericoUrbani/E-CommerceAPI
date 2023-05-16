package it.develhope.shoppyz.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
    accountRepository.saveAndFlush(account);
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

    public void deleteById(Integer id){accountRepository.deleteById(id);}

    /*
    public void putProduct (Product product){
        Product prov= new Product();
        //prov.set
        productRepository.saveAndFlush(product);
    }
    */

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
