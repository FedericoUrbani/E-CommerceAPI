package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CartService {
    public List<Cart> findAllCart();

    public Optional<Cart> getCart(Long id);

    public void updateCart(Cart cart);



    public Cart findById(Long id);

    public void removeCart(Long id);





    public void saveCart(Cart cart);

    void removedProduct(Product product, Long quantity);
}

