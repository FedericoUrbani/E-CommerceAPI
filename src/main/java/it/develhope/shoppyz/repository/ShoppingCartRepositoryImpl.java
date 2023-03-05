package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.ShoppingCart;

public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {
    @Override
    public ShoppingCart getToCart(Product product) {
        //selezionare un prodotto al carrello
        return null;
    }

    @Override
    public void postToCart(ShoppingCart shoppingCart) {
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
