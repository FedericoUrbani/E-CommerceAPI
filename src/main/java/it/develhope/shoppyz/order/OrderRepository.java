package it.develhope.shoppyz.order;

import it.develhope.shoppyz.cartitem.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByAccountId(Long accountid);
}
