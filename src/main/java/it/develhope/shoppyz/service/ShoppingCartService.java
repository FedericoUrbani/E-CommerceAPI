package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Product;

import java.util.List;

public interface IShoppingCartService {
    public void addProduct(Product product, int quantity);
    public void printItems();
    public double totalPrice();
    public void removedProduct(Product product, int quantity);



}
