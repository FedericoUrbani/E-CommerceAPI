package it.develhope.shoppyz.utils;

import it.develhope.shoppyz.order.OrderProduct;
import it.develhope.shoppyz.product.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProductConverter {

    @Autowired
    private ModelMapper modelMapper;

    public OrderProduct convertProduct(Product product){
        OrderProduct ordProd= modelMapper.map(product, OrderProduct.class);
        return ordProd;
    }

}
