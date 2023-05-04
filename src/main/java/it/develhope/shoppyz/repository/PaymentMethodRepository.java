package it.develhope.shoppyz.repository;
import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<Account,Integer> {



}
