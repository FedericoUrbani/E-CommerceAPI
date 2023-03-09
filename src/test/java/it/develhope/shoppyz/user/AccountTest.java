package it.develhope.shoppyz.user;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Address;
import it.develhope.shoppyz.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {
User user;
Account account;
Address address;
    @BeforeEach
    void setUp() {
        address= new Address("via campaccio","Campo Basso", "Italia","01923");
        user = new User(1,"Roberto","Marziano",address,"3346893345","robertinoMarz@gmail.com");
      //  account= new Account(1,user,"Robertino","gallo900");
    }

    @Test
    void runAccountToString(){
        //mi stampa tutti i valori che sono presenti nelle classi address & user in account
        System.out.println(account.toString());
    }
}