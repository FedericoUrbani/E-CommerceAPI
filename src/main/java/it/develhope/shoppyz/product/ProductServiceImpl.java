package it.develhope.shoppyz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product){
        productRepository.save(product);
        return product;
    }

    @Override
    public void updateProduct(Product product){
        productRepository.saveAndFlush(product);

    }
    @Override
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

}
