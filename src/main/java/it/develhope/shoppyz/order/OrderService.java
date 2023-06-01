package it.develhope.shoppyz.order;

import it.develhope.shoppyz.cartitem.CartItem;
import it.develhope.shoppyz.cartitem.CartItemRepository;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.utils.OrderProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    OrderProductConverter orderProductConverter;

    @Autowired
    OrderRepository orderRepository;

    /**
     * random number generator
     **/
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * random tracking number generator
     **/
    public String randomTrackingNumberGenerator() {

        StringBuilder buffer = new StringBuilder(12);
        buffer.append("IT");
        for (int i = 0; i < 10; i++) {
            int r = getRandomNumber(1, 2);
            if (r == 1)
                buffer.append((char) getRandomNumber(48, 57));
            if (r == 2)
                buffer.append((char) getRandomNumber(65, 90));
        }
        String returnedString = buffer.toString();
        return returnedString;
    }

    public Order createOrder(Long accountId, byte isgift) {
        Order order = new Order();
        List<CartItem> prodlist = cartItemRepository.findAllByAccountId(accountId);
        List<Product> prodInCart = new ArrayList();
        List<OrderProduct> prodInOrd = new ArrayList<>();
        order.setTotaleprice(0);
        order.setIsgift(isgift);
        order.setAccountId(accountId);
        order.setTrackingNumber(randomTrackingNumberGenerator());
        order.setCreateDate(new java.util.Date());
        order.setOrderStatus(OrderStatus.OrderConfirmed);
        List<Integer> quantities = new ArrayList<>();

        for (CartItem ci : prodlist) {
            if(ci.getQuantity()>0) {
                prodInCart.add(ci.getProduct());
                quantities.add(ci.getQuantity());
            }
        }
        for (int index = 0; index < prodInCart.size(); index++) {
            OrderProduct ordProd = orderProductConverter.convertProduct(prodInCart.get(index));
            ordProd.setQuantity(quantities.get(index));
            prodInOrd.add(ordProd);
            double actualPrice = 0;
            for (int i = 0; i < ordProd.getQuantity(); i++) {
                actualPrice = actualPrice + ordProd.getPrice();
            }
            ordProd.setPrice(actualPrice);
            order.setTotaleprice(order.getTotaleprice() + ordProd.getPrice());

        }
        order.setProductsOrder(prodInOrd);
        orderRepository.saveAndFlush(order);
        return getOrderByAccountId(accountId);
    }

    public Order getOrderByAccountId(Long id) {
        return orderRepository.findByAccountId(id);
    }

}
