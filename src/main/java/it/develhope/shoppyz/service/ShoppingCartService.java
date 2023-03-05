package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Product;

public interface ShoppingCartService {
    public void addProduct(Product product, int quantity);
    public void printItems();
    public double totalPrice();
    public void removedProduct(Product product, int quantity);



}
