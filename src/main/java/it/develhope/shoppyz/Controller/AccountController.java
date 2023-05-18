package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Shoppyz/account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @GetMapping("/findall")
    public List<Account> findall(){
        return accountServiceImpl.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletebyId(@PathVariable Long id){
             accountServiceImpl.deleteById(id);
    }

    @GetMapping(value = "/findbyid/{id}")
    public Optional<Account> getAccountById(@PathVariable Long id){
       return accountServiceImpl.getAccount(id);
    }
    @PutMapping("/update/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Account account){
        account.setId(id);
        accountServiceImpl.updateAccount(account);
    }
    @PostMapping("/saveaccount")
    public Account saveAccount(@RequestBody Account account){
        System.out.println(account.toString());
        return accountServiceImpl.saveAccount(account);
    }


}
