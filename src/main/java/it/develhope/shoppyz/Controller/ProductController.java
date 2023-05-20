package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Shoppyz/product")
public class ProductController {

    @Autowired
    ProductService productServiceImpl;

    @GetMapping("/findall")
    public List<Product> findAll(){
        return productServiceImpl.getProductList();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productServiceImpl.createProduct(product);

    }

    @GetMapping(value = "/findbyid/{id}")
    public Product findProductById(@PathVariable Long id){
        return productServiceImpl.getProduct(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        productServiceImpl.updateProduct(product);
    }

   @DeleteMapping(value = "/delete/{id}")
    public void deleteProductbyID(@PathVariable Long id){
       productServiceImpl.deleteProductById(id);
   }


}
