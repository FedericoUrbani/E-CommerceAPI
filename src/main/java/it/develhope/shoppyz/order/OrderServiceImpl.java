package it.develhope.shoppyz.order;

import it.develhope.shoppyz.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void postOrder(Order order, Account id) {
        orderRepository.saveAndFlush(order);
    }

    @Override
    public Optional<Order> getOrder(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    public void updateOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


}