package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CartService {
    public List<Cart> findAllCart();

    public Optional<Cart> getCart(int id);

    public void updateCart(Cart cart);



    void addProductToCart(Cart cart, Product product, int quantity);

    public Cart findById(int id);

    public void removeCart(Integer id);

    public void saveCart(Cart cart);




    List<Product> removedProduct(List<Product> list, int id_prod);
}

