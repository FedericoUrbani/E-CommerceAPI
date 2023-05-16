package it.develhope.shoppyz.account;

import it.develhope.shoppyz.account.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

     Optional<Account> findById(Integer id);

     @Override
     void deleteById(Integer integer);

     List<Account> findAll();

}
