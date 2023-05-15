package it.develhope.shoppyz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    public Optional<Product> getProduct(Integer id){
        return productRepository.findById(id);
    }

    public void postProduct(Product product){
        productRepository.saveAndFlush(product);
    }

    @Override
    public void updateProduct(Product product){
        productRepository.saveAndFlush(product);
    }
    @Override
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

}
