package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;

import java.util.List;

public interface ProductRepository {
    public Product getProduct(int id);
    public void postProduct(Product product);
    public void updateProduct(String id);
    public void deleteProduct(String id);

    public List<Product> getProduct(List<Product> products);
}
