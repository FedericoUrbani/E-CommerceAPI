package it.develhope.shoppyz.user;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AccountTest {

    AccountServiceImpl service= new AccountServiceImpl();

    @BeforeEach
    void setUp() {
        service.listedAccounts();
        List<Account> list= service.listedAccounts();
        Assert.assertTrue(list!=null);
    }


    @Test
    void runAccountToString(){
        Account account = service.getAccount(1);
        System.out.println(account.toString());
    }
}