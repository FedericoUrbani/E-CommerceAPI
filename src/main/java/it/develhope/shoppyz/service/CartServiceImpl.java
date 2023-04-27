package it.develhope.shoppyz.service;

import it.develhope.shoppyz.DTO.Cart.CART_DTO_ADD;
import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.repository.CartRepository;
import it.develhope.shoppyz.repository.CartRepositoryImpl;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {
    CartRepository cartRepository = new CartRepositoryImpl();

    public Cart getToCart(Product product){
        return cartRepository.getToCart(product);
    }

    public void postToCart(Cart cart){
        cartRepository.postToCart(cart);
    }

    public void updateToCart(Product product){
        cartRepository.updateToCart(product);
    }

    public void deleteToCart(Product product){
        cartRepository.deleteToCart(product);
    }

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

    }

    @Override
    public void addToCart(CART_DTO_ADD cartDtoAdd) {

        //Validare id prodotto

        ProductServiceImpl.findById(cartDtoAdd.getProduct_id());

    }

    /*
    implementare i 4 metodi dell'interfaccia inserendo il corpo
    metodo addProduct(){}
    metodo printItems(){}
    metodo totalPrice(){}
    metodo removeProduct(){}
     */

}
