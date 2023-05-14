package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.*;
import it.develhope.shoppyz.repository.CartRepository;
import it.develhope.shoppyz.repository.OrderRepository;
import it.develhope.shoppyz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository ;
    @Autowired
    OrderRepository orderRepository;


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
    public void addProductToCart(Cart cart, Product product, int quantity) {

        Cart cartProv= cart;
        product.setQuantity(quantity);
        cartProv.getProductsInCart().add(product);

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
    public List<Product> removedProduct(List<Product> list, int id_prod) {


        // Cerca il prodotto con l'id specificato nella lista
        Product prodToRemove = null;
        for (Product prod : list) {
            if (prod.getId() == id_prod) {
                prodToRemove = prod;
                break;
            }
        }

        // Rimuovi il prodotto dalla lista, se presente
        if (prodToRemove != null) {
            list.remove(prodToRemove);
        }

        // Ritorna la lista aggiornata
        return list;
    }


    public void makeOrder(Cart cart){
        Order provOrd= new Order();
        provOrd.setCreateDate(new java.util.Date());
        provOrd.setIsgift(cart.getIsgift());
        provOrd.setTrackingNumber(randomTrackingNumberGenerator());
        provOrd.setBuyerAccount(cart.getAccount());
        provOrd.setProductsList(cart.getProductsInCart());
        orderRepository.saveAndFlush(provOrd);
    }

    /** logica per autogenerazione trackingnumb */

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String randomTrackingNumberGenerator(){

        StringBuilder buffer = new StringBuilder(12);
        buffer.append("IT");
        for(int i = 0; i< 10; i++){
            int r= getRandomNumber(1,2);
            if(r==1)
            buffer.append((char) getRandomNumber(48,57));
            if(r==2)
            buffer.append((char) getRandomNumber(65,90));
        }
        String returnedString= buffer.toString();
        return returnedString;
    }





}
