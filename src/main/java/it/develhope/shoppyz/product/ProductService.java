package it.develhope.shoppyz.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Optional<Product> getProduct(Long id);
    public Product createProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProductById(Long id);

     public List<Product> getProductList();
}
