package it.develhope.shoppyz.user;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.address.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
User user;
Account account;
Address address;
    @BeforeEach
    void setUp() {
        address= new Address("via campaccio","Campo Basso", "Italia","01923");
        user = new User(1,"Roberto","Marziano",address,"3346893345","robertinoMarz@gmail.com");
        account= new Account(user,"Robertino","gallo900");
    }

    @Test
    void runUserToString(){
        //mi stampa tutti i valori che sono presenti nelle classi address & user in account
        System.out.println(account.toString());
    }
}