package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productRepository.saveAndFlush(product);
    }

    @GetMapping
    public List<Product> getList(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getSingle(@PathVariable int id){
        return productRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product){
        product.setId(id);
        return productRepository.saveAndFlush(product);
    }

   @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id, HttpServletResponse response){
       if (productRepository.existsById(id)){
           productRepository.deleteById(id);
       }else{
           response.setStatus(409);
       }
   }




}
