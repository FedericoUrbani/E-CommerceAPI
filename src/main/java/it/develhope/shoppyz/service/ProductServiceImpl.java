package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.repository.ProductRepository;
import it.develhope.shoppyz.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository= new ProductRepositoryImpl();
    public Product getProduct(String id){
        return null;//productRepository.getProduct(id);
    }

    public void postProduct(Product product){
        productRepository.postProduct(product);
    }

    public void updateProduct(String id){
        productRepository.updateProduct(id);
    }

    public void deleteProduct(String id){
        productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> listProduct(List<Product> list) {
        productRepository.getProduct(list);
        return null;
    }
}
