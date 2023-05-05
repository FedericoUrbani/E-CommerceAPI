package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Address;
import it.develhope.shoppyz.service.AccountService;
import it.develhope.shoppyz.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
