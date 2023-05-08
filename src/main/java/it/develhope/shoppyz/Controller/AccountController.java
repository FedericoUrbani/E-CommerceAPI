package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.repository.AccountRepository;
import it.develhope.shoppyz.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Shoppyz/account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountServiceImpl;


    @GetMapping("/randomacc")
    public List<Account> createRandomAccounts (){
        return accountServiceImpl.createBaseRandomAccounts(100);
    }
    @GetMapping("/findall")
    public List<Account> findall (){
        return accountServiceImpl.findAll();
    }

    @DeleteMapping(value = "/deleteaccount/{id}")
    public void deletebyId(@PathVariable Integer id){
             accountServiceImpl.deleteById(id);
    }

    @GetMapping(value = "/findaccountbyid/{id}")
    public Optional<Account> getAccountById(@PathVariable Integer id){
       return accountServiceImpl.getAccount(id);
    }
    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Integer id, @RequestBody Account account){
        account.setId(id);
        accountServiceImpl.updateAccount(account);
    }

    @PostMapping("/saveaccount")
    public void saveAccount(@RequestBody Account account){
        accountServiceImpl.saveAccount(account);
    }

}
