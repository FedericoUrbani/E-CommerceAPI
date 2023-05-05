package it.develhope.shoppyz.service;
import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Order;

import java.util.List;

public interface OrderService {

        public Order getOrder(Integer id);
        public void deleteOrder(Order order);
        public void postOrder(Order order, Account id);
        public void updateOrder(Order order);
        public List<Order> getOrders();
    }


