package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Product;

import java.util.List;

public interface ProductService {
    public void postProduct(Product product);
    public void updateProduct(Product product, int id);
    public void getProduct(int id);

    public void deleteProduct(int id);

     List<Product> listProduct();
}
