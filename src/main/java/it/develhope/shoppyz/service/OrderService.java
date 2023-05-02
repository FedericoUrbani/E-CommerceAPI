package it.develhope.shoppyz.service;
import it.develhope.shoppyz.entity.Order;

import java.util.List;

public interface OrderService {

        public Order getOrder(int id);
        public void deleteOrder(int id);
        //public void saveOrder(Order order, int userId);
        public void updateOrder(int id, Order order);
        public List<Order> getOrders();
    }


