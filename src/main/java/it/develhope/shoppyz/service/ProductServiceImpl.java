package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.repository.IProductRepository;
import it.develhope.shoppyz.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{

    IProductRepository productRepository= new ProductRepository();
    public Product getProduct(String id){
        return productRepository.getProduct(id);
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
