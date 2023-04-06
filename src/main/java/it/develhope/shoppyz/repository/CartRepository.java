package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.Cart;

public interface CartRepository {
    public Cart getToCart(Product product);
    public void postToCart(Cart cart);
    public void updateToCart(Product product);
    public void deleteToCart(Product product);

    //public List<ShoppingCart> getToCart(List<ShoppingCart> shoppingCarts);

}
