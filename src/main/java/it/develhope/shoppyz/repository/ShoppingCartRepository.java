package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.ShoppingCart;

public interface ShoppingCartRepository {
    public ShoppingCart getToCart(Product product);
    public void postToCart(ShoppingCart shoppingCart);
    public void updateToCart(Product product);
    public void deleteToCart(Product product);

    //public List<ShoppingCart> getToCart(List<ShoppingCart> shoppingCarts);

}
