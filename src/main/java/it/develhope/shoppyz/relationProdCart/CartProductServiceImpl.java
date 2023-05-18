package it.develhope.shoppyz.relationProdCart;


import it.develhope.shoppyz.DTO.ProductDTO;
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


    public List<Product> getProductsInCart(Long cart_id){
        List<CartProduct> listOfId= cartProductRepository.getListOfProductInCart(cart_id);
        List<Product> productsList = new ArrayList<>();
        for (CartProduct p: listOfId){
            productsList.add(productRepository.getReferenceById(p.getCart().getId()));
        }
        return productsList;
    }

    public List <ProductDTO> getProductasDTO(List<Product> productList){
        List<ProductDTO> DTOList= new ArrayList<>();
        for (Product p: productList){
            DTOList.add(productDTOConverter.convertProducttoDTO(p));
        }
        return DTOList;
    }
}
