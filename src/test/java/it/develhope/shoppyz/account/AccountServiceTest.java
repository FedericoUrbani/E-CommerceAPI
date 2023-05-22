package it.develhope.shoppyz.account;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;

import static it.develhope.shoppyz.account.PaymentType.paypal;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void checkAccountActivation() throws Exception {
        Account account = new Account();
        account.setId(1L);
        account.setName("Gabri");
        account.setSurname("Casti");
        account.setAddresses(null);
        account.setEnabled((byte) 0);
        account.setEmail("example@x.it");

        PaymentMethod paymentMethod = new PaymentMethod(paypal, "web pay");
        account.setPaymentMethods(List.of(paymentMethod));

        account.setPassword("1234GC");
        account.setPhoneNumber("333333333");

        Account savedAccount = accountService.saveAccount(account);
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getId()).isNotNull();

        Account retrievedAccount = accountService.getAccount(savedAccount.getId());
        assertThat(retrievedAccount).isNotNull();
        assertThat(retrievedAccount.getId()).isEqualTo(savedAccount.getId());
        assertThat(retrievedAccount.getEnabled()).isEqualTo((byte) 0);

        retrievedAccount.setEnabled((byte) 1);
        accountService.updateAccount(retrievedAccount);




        Account updatedAccount = accountService.getAccount(retrievedAccount.getId());
        assertThat(updatedAccount).isNotNull();
        assertThat(updatedAccount.getEnabled()).isEqualTo((byte) 1);

        accountService.deleteById(updatedAccount.getId());


        boolean isAccountDeleted = !accountRepository.existsById(updatedAccount.getId());
        assertThat(isAccountDeleted).isTrue();
    }
}

