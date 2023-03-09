package it.develhope.shoppyz.user;


import it.develhope.shoppyz.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product;

    @BeforeEach
    void setUpProduct(){
       // product=new Product("01","food",9.99,"snackCheese.jpg","100");

    }

    @Test
    void runTestProduct(){
        System.out.println(product.toString());
    }
}
