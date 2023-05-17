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

    @Override
    public void postOrder(Order order, Account account) {
        /** l oggetto order viene cosi aggiornato con l account specificato utilizzanto setBuyerAccount **/
        order.setBuyerAccount(account);
        orderRepository.saveAndFlush(order);
    }


    @Override
    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }



    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


}
