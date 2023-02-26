package it.develhope.shoppyz.account;

import it.develhope.shoppyz.user.User;

public class Account  {
    private String accountName;
    private String accountPass;
    private boolean sellsAccountActivation;
    private SellsAccount sellsAccount;
    private boolean enabledAccount = true;

    private boolean doubleAuthentication=false;
    private String authenticatedPhoneNumber;

    private User user;
    private String recoveryMail;

    public Account(User user, String accountName, String accountPass) {

        this.user=user;
        this.accountName = accountName;
        this.accountPass = accountPass;
        this.sellsAccountActivation = false;
        this.sellsAccount = null;
        this.enabledAccount = true;
        this.doubleAuthentication = false;
        this.authenticatedPhoneNumber = null;
        this.recoveryMail = user.getEmail();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPass() {
        return accountPass;
    }

    public void setAccountPass(String accountPass) {
        this.accountPass = accountPass;
    }

    public boolean isSellsAccountActivation() {
        return sellsAccountActivation;
    }

    public void setSellsAccountActivation(boolean sellsAccountActivation) {
        this.sellsAccountActivation = sellsAccountActivation;
    }

    public SellsAccount getSellsAccount() {
        return sellsAccount;
    }

    public void setSellsAccount(SellsAccount sellsAccount) {
        this.sellsAccount = sellsAccount;
    }

    public boolean isEnabledAccount() {
        return enabledAccount;
    }

    public void setEnabledAccount(boolean enabledAccount) {
        this.enabledAccount = enabledAccount;
    }

    public boolean isDoubleAuthentication() {
        return doubleAuthentication;
    }

    public void setDoubleAuthentication(boolean doubleAuthentication) {
        this.doubleAuthentication = doubleAuthentication;
    }

    public String getAuthenticatedPhoneNumber() {
        return authenticatedPhoneNumber;
    }

    public void setAuthenticatedPhoneNumber(String authenticatedPhoneNumber) {
        this.authenticatedPhoneNumber = authenticatedPhoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecoveryMail() {
        return recoveryMail;
    }

    public void setRecoveryMail(String recoveryMail) {
        this.recoveryMail = recoveryMail;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountPass='" + accountPass + '\'' +
                ", sellsAccountActivation=" + sellsAccountActivation +
                ", sellsAccount=" + sellsAccount +
                ", enabledAccount=" + enabledAccount +
                ", doubleAuthentication=" + doubleAuthentication +
                ", authenticatedPhoneNumber='" + authenticatedPhoneNumber + '\'' +
                ", user=" + user +
                ", recoveryMail='" + recoveryMail + '\'' +

                '}';
    }
}
