package it.develhope.shoppyz.command;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Address;
import it.develhope.shoppyz.payment.CreditCard;
import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.User;

public class Main {
    public static void main(String[] args) {
        // create first user
        Address address1= new Address("via leornardo da vinci","palermo","italy","90145");
        User user1=new User(1999,"Gabri","casti",address1,"3333333","gabri@gmail.com");
        Account account1= new Account(1999,user1,"Gabri0801","19990801G");

        //create first credit card
        CreditCard creditCard1=new CreditCard("11111111111","Gabri casti",111,"01/24");

        //create first product
        Product product1=new Product("0000","food",10.00,"jpg.snackCheese","100");
        product1.setStockedAmount("100");


    }
}
