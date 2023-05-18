package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductRepository;
import it.develhope.shoppyz.product.ProductServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Shoppyz/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("/findall")
    public List<Product> findAll(){
        return productServiceImpl.getProductList();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productServiceImpl.createProduct(product);

    }

    @GetMapping(value = "/findbyid/{id}")
    public Optional<Product> findProductById(@PathVariable Long id){
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
