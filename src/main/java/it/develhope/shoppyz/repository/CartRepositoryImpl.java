package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.Cart;

public class CartRepositoryImpl implements CartRepository {
    @Override
    public Cart getToCart(Product product) {
        //selezionare un prodotto al carrello
        return null;
    }

    @Override
    public void postToCart(Cart cart) {
        //aggiungere un prodotto al carrello
    }

    @Override
    public void updateToCart(Product product) {
        //modificare i prodotti nel carrello
    }

    @Override
    public void deleteToCart(Product product) {
        //eliminare un prodotto dal carrello
    }

    /*
    @Override
    public List<ShoppingCart> getToCart(List<ShoppingCart> shoppingCarts) {
        return null;
    }
     */

}
