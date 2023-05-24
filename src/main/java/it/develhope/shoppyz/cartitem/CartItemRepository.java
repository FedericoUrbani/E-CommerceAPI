package it.develhope.shoppyz.cartitem;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findAllByAccountId(Long account);

}

