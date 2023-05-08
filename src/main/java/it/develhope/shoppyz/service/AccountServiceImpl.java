package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Address;
import it.develhope.shoppyz.entity.PaymentMethod;
import it.develhope.shoppyz.entity.PaymentType;
import it.develhope.shoppyz.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;


    /**
     * @return get the account:
     */
    public Optional<Account> getAccount(Integer id) {
        return accountRepository.findById(id);
    }

    /**
     * @return delete the account.
     */
    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }
    /**
     * @return save the account.
     */
    @Override
    public void saveAccount(Account account) {
    accountRepository.save(account);
    }
    /**
     * @return update the user with the id of.
     */
    @Override
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }
    /**
     * @return returns the list of accounts
     */

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    public void deleteById(Integer id){accountRepository.deleteById(id);}

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String randomStringGenerator(int j){

        int targetStringLength = j;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for(int i=0;i<targetStringLength;i++){
            buffer.append((char) getRandomNumber(97,122));
        }
        String returnedString= buffer.toString();
        return returnedString;
    }



    public List<Account> createBaseRandomAccounts(int number){
        List<Account> accountList = new ArrayList<>();
        for (int i=0;i<number;i++){
            List<Address> addressList= new ArrayList<>();
            Address randomAddress=new Address(
                    randomStringGenerator(4),
                    randomStringGenerator(6),
                    randomStringGenerator(5),
                    randomStringGenerator(4));
            addressList.add(randomAddress);

            List<PaymentMethod> paymentList= new ArrayList<>();
            PaymentMethod randomPaymentMethod=new PaymentMethod(
                    PaymentType.randomPayment(),
                    randomStringGenerator(3));
            paymentList.add(randomPaymentMethod);


            Account Randomaccount= new Account();
            Randomaccount.setAddresses(addressList);
            Randomaccount.setPaymentMethods(paymentList);
            Randomaccount.setEmail(randomStringGenerator(8));
            Randomaccount.setName(randomStringGenerator(8));
            Randomaccount.setName(randomStringGenerator(8));
            Randomaccount.setSurname(randomStringGenerator(8));
            Randomaccount.setEnabled((byte) 1);
            Randomaccount.setPhoneNumber(randomStringGenerator(13));
            accountRepository.save(Randomaccount);
            accountList.add(Randomaccount);

        }
        return accountList;
    }


    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
