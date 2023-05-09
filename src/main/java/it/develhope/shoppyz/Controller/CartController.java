package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @GetMapping("/findall")
    public List<Cart> findAll() {
        return cartServiceImpl.findAllCart();
    }

    @GetMapping(value = "/findCartbyid/{id}")
    public Optional<Cart> getCartById(@PathVariable Integer id) {
        return cartServiceImpl.getCart(id);
    }


    @PutMapping("/{id}")
    public void updateCart(@PathVariable Integer id, @RequestBody Cart cart) {
        cart.setId(id);
        cartServiceImpl.updateCart(cart);
    }

    public void addProductToCart(Product product, Account account, int quantity) {

    }

    @GetMapping(value = "/findCartById/{id}")
    public Cart findById(@PathVariable Integer id) {
        return cartServiceImpl.findById(id);
    }

    @DeleteMapping("/deletecart/{id}")
    public void removeCartId(Integer id) {
        cartServiceImpl.removeCart(id);
    }

    @PostMapping("/savecart")
    public void saveCart(@RequestBody Cart cart) {
        cartServiceImpl.saveCart(cart);
    }


    public void removedProduct(Product product, int quantity) {

    }
}


