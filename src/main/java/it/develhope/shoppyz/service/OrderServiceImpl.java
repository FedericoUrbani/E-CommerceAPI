package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Order;
import it.develhope.shoppyz.repository.OrderRepositoryImpl;


import java.util.List;

public class OrderServiceImpl implements OrderService{
    OrderRepositoryImpl orderRepository=new OrderRepositoryImpl();

    /**
     * @return Get the order with the id of:
     */
    @Override
    public Order getOrder(int id) {

       return orderRepository.getOrder(id);
    }
    /**
     * @return delete the order with the id of:
     */
    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteOrder(id);
    }
    /**
     * @return save the order :
     */
   /* @Override
    public void saveOrder(Order order, int userId) {
        orderRepository.saveOrder(order, userId);
    }
    /**
     * @return update the order with the id of with the order:
     */
    @Override
    public void updateOrder(int id, Order order) {
        orderRepository.updateOrder(id,order);
    }
    /**
     * @return Get the list of all orders:
     */
    @Override
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }
}
