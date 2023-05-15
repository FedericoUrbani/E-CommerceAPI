package it.develhope.shoppyz.product;

import it.develhope.shoppyz.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Optional<Product> getProduct(Integer id);
    public void postProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(Product product);

     public List<Product> getProductList();
}
