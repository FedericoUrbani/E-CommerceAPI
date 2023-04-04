package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Order;

import java.util.List;

public interface OrderRepository {


        public Order getOrder(int id);

        public void deleteOrder(int id);

        public void saveOrder(Order account, int userId);

        public void updateOrder(int id, Order account);

        public List<Order> getOrders();

    }

