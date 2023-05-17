package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.order.OrderRepository;
import it.develhope.shoppyz.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository ;
    @Autowired
    OrderRepository orderRepository;


    @Override
    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getCart(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public Cart findById(Long id) {
        return  cartRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void removedProduct(Product product, Long quantity) {

    }

    /** logica per autogenerazione trackingnumb */

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String randomTrackingNumberGenerator(){

        StringBuilder buffer = new StringBuilder(12);
        buffer.append("IT");
        for(int i = 0; i< 10; i++){
            int r= getRandomNumber(1,2);
            if(r==1)
            buffer.append((char) getRandomNumber(48,57));
            if(r==2)
            buffer.append((char) getRandomNumber(65,90));
        }
        String returnedString= buffer.toString();
        return returnedString;
    }

}
