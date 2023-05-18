package it.develhope.shoppyz.relationProdCart;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cart_ProductServiceImpl {

    @Autowired
    Cart_ProductRepository cartProductRepository;

    @Autowired
    ProductRepository productRepository;


    public List<Product> getProductsInCart(Long cart_id){
        List<Cart_Product> listOfId= cartProductRepository.getListOfProductInCart(cart_id);
        List<Product> productsList = new ArrayList<>();
        for (Cart_Product p: listOfId){
            productsList.add(productRepository.getReferenceById(p.getCart().getId()));
        }
        return productsList;
    }
}
