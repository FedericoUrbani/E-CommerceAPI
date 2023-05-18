package it.develhope.shoppyz.relationProdCart;


import it.develhope.shoppyz.DTO.ProductDTO;
import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductRepository;
import it.develhope.shoppyz.utils.ProductDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartProductServiceImpl {

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDTOConverter productDTOConverter;



    public List <ProductDTO> getProductasDTO(List<Product> productList){
        List<ProductDTO> DTOList= new ArrayList<>();
        for (Product p: productList){
            DTOList.add(productDTOConverter.convertProducttoDTO(p));
        }
        return DTOList;
    }
}
