package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.cart.CartServiceImpl;
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
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return cartServiceImpl.getCart(id);
    }


    @PutMapping("/{id}")
    public void updateCart(@PathVariable Long id, @RequestBody Cart cart) {

        cartServiceImpl.updateCart(cart);
    }

    @GetMapping(value = "/findCartById/{id}")
    public Cart findById(@PathVariable Long id) {
        return cartServiceImpl.findById(id);
    }

    @DeleteMapping("/deletecart/{id}")
    public void removeCartId(Long id) {
        cartServiceImpl.removeCart(id);
    }

    @PostMapping("/savecart")
    public void saveCart(@RequestBody Cart cart) {
        cartServiceImpl.saveCart(cart);
    }


    public void removedProduct(Product product, int quantity) {

    }
}


