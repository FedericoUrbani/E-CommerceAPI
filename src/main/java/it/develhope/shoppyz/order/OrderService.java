package it.develhope.shoppyz.order;
import it.develhope.shoppyz.account.Account;

import java.util.List;
import java.util.Optional;

public interface OrderService {

        public Optional<Order> getOrder(Integer id);
        public void deleteOrder(Order order);
        public void postOrder(Order order, Account id);
        public void updateOrder(Order order);
        public List<Order> getOrders();
    }


