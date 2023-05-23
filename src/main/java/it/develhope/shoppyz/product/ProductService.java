package it.develhope.shoppyz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * return the product by id
     **/
    public Product getProduct(Long id) {
        return productRepository.getReferenceById(id);
    }

    /**
     * return saved product
     **/
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    /**
     * update the product passed in parameter
     **/
    public void updateProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    /**
     * delete the product by id
     **/
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * find all product in repository
     **/
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

}
