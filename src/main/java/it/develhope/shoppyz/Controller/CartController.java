package it.develhope.shoppyz.Controller;


import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.entity.Product;
import it.develhope.shoppyz.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Integer id) {
        Optional<Cart> cart = cartServiceImpl.getCart(id);
        if (cart.isPresent()) {
            return ResponseEntity.ok(cart.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCart(@PathVariable Integer id, @RequestBody Cart cart) {
        Optional<Cart> existingCart = cartServiceImpl.getCart(id);
        if (existingCart.isPresent()) {
            cart.setId(id);
            cartServiceImpl.updateCart(cart);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/product")
    public ResponseEntity<Void> addProductToCart(@PathVariable Integer id, @RequestBody Product product, @RequestParam("quantity") int quantity) {
        Optional<Cart> existingCart = cartServiceImpl.getCart(id);
        if (existingCart.isPresent()) {
            cartServiceImpl.addProductToCart(existingCart.get(), product, quantity);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
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


    @DeleteMapping("/{id}/product/{productId}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Integer id, @PathVariable Integer productId) {
        Optional<Cart> existingCart = cartServiceImpl.getCart(id);
        if (existingCart.isPresent()) {
            List<Product> productsInCart = existingCart.get().getProductsInCart();
            int originalSize = productsInCart.size();
            cartServiceImpl.removedProduct(productsInCart, productId);
            int newSize = productsInCart.size();
            if (newSize < originalSize) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/{id}/order")
    public ResponseEntity<Void> makeOrder(@PathVariable Integer id) {
        Optional<Cart> existingCart = cartServiceImpl.getCart(id);
        if (existingCart.isPresent()) {
            cartServiceImpl.makeOrder(existingCart.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/product/{productId}/quantity")
    public ResponseEntity<Void> updateProductQuantityInCart(@PathVariable Integer id, @PathVariable Integer productId, @RequestParam int quantity) {
        Optional<Cart> existingCart = cartServiceImpl.getCart(id);
        if (existingCart.isPresent()) {
            List<Product> productsInCart = existingCart.get().getProductsInCart();
            for (Product product : productsInCart) {
                if (product.getId()==productId) {
                    product.setQuantity(quantity);
                    return ResponseEntity.noContent().build();
                }
            }
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


