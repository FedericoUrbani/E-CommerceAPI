package it.develhope.shoppyz.account;

import it.develhope.shoppyz.account.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

     Optional<Account> findById(Long id);

     @Override
     void deleteById(Long id);

     List<Account> findAll();

}
