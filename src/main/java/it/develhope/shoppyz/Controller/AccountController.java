package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Shoppyz/account")
public class AccountController {

    @Autowired
    AccountService accountServiceImpl;

    @GetMapping("/findall")
    public List<Account> findall(){
        return accountServiceImpl.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletebyId(@PathVariable Long id){
             accountServiceImpl.deleteById(id);
    }

    @GetMapping(value = "/findbyid/{id}")
    public Account getAccountById(@PathVariable Long id){
       return accountServiceImpl.getAccount(id);
    }
    @PutMapping("/update/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Account account){
        account.setId(id);
        accountServiceImpl.updateAccount(account);
    }
    @PostMapping("/saveaccount")
    public Account saveAccount(@RequestBody Account account){
        return accountServiceImpl.saveAccount(account);
    }


}
