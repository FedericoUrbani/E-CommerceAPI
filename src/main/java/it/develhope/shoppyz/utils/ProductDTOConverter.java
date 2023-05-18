package it.develhope.shoppyz.utils;

import it.develhope.shoppyz.DTO.ProductDTO;

import it.develhope.shoppyz.product.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO convertProducttoDTO(Product product){
        ProductDTO productDto= modelMapper.map(product, ProductDTO.class);
        return productDto;
    }

}