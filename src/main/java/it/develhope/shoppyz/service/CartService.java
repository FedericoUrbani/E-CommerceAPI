package it.develhope.shoppyz.service;

import it.develhope.shoppyz.DTO.Cart.CART_DTO_ADD;
import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.entity.Product;
import org.springframework.stereotype.Service;


@Service
public interface CartService {
    public void addProduct(Product product, int quantity);
    public void printItems();
    public double totalPrice();
    public void removedProduct(Product product, int quantity);


    public void addToCart(CART_DTO_ADD cartDtoAdd);

    Cart getCartByUserId(int userId);

    void saveCart(Cart cart);
}
