package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.ShoppingCart;
import it.develhope.shoppyz.repository.ShoppingCartRepository;
import it.develhope.shoppyz.repository.ShoppingCartRepositoryImpl;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    ShoppingCartRepository cartRepository = new ShoppingCartRepositoryImpl();

    public ShoppingCart getToCart(Product product){
        return cartRepository.getToCart(product);
    }

    public void postToCart(ShoppingCart shoppingCart){
        cartRepository.postToCart(shoppingCart);
    }

    public void updateToCart(Product product){
        cartRepository.updateToCart(product);
    }

    public void deleteToCart(Product product){
        cartRepository.deleteToCart(product);
    }

    /*
    @Override
    public void addProduct(Product product, int quantity) {

    }

    @Override
    public void printItems() {

    }

    @Override
    public double totalPrice() {
        return 0;
    }

    @Override
    public void removedProduct(Product product, int quantity) {

    }*/

    /*
    implementare i 4 metodi dell'interfaccia inserendo il corpo
    metodo addProduct(){}
    metodo printItems(){}
    metodo totalPrice(){}
    metodo removeProduct(){}
     */

}
