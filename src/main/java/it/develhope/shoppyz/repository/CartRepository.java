package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Account,Integer> {



}
