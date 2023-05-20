package it.develhope.shoppyz.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService  {

    @Autowired
    AccountRepository accountRepository;

    /**
     * @return get the account:
     */
    public Account getAccount(Long id) {
        return accountRepository.getReferenceById(id);
    }

    /**
     * @return save the account.
     */
    public Account saveAccount(Account account) {
    accountRepository.save(account);
    return account;
    }
    /**
     *  update the user with the id of.
     */
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }
    /**
     *  delete the accounts
     */
    public void deleteById(Long id){accountRepository.deleteById(id);}
    /** finds all present accounts **/
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
