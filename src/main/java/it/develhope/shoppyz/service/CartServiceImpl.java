package it.develhope.shoppyz.service;

import it.develhope.shoppyz.DTO.Cart.CART_DTO_ADD;
import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository ;


    @Override
    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getCart(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void addProductToCart(Product product, Account account, int quantity) {

    }

    @Override
    public Cart findById(int id) {
        return  cartRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCart(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void removedProduct(Product product, int quantity) {

    }
}
