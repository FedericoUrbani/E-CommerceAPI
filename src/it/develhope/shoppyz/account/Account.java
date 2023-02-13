package it.develhope.shoppyz.account;

import it.develhope.shoppyz.address.Address;
import it.develhope.shoppyz.user.User;

public class Account extends User {
    private String accountName;
    private String accountPass;
    private boolean sellsAccountActivation;
    private SellsAccount sellsAccount;
    private boolean enabledAccount = true;

    private boolean doubleAuthentication=false;
    private String authenticatedPhoneNumber;

    private String recoveryMail;

    public Account(int id, String name, String surname, String city, Address address, String phoneNumber, Account account, String accountName, String accountPass, boolean sellsAccountActivation, SellsAccount sellsAccount, boolean enabledAccount, boolean doubleAuthentication, String authenticatedPhoneNumber, String recoveryMail) {
        super(id, name, surname, city, address, phoneNumber, account);
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.sellsAccountActivation = sellsAccountActivation;
        this.sellsAccount = sellsAccount;
        this.enabledAccount = enabledAccount;
        this.doubleAuthentication = doubleAuthentication;
        this.authenticatedPhoneNumber = authenticatedPhoneNumber;
        this.recoveryMail = recoveryMail;
    }
}
