package it.develhope.shoppyz.Controller;



import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.cart.CartServiceImpl;
import it.develhope.shoppyz.relationProdCart.CartProductRepository;
import it.develhope.shoppyz.relationProdCart.CartProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Shoppyz/cart")
public class CartController {

    @Autowired
    private CartProductServiceImpl cartProductServiceImpl;
    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Autowired
    CartProductRepository cartProductRepository;
    @GetMapping("/{id}")
    public Cart getProductsFromCart(@PathVariable Long id) throws Exception {
        return null;
    }

    @GetMapping("/findall")
    public List<Cart> findAll() {
        return cartServiceImpl.findAllCart();
    }

    @GetMapping(value = "/findCartbyid/{id}")
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return cartServiceImpl.getCart(id);
    }


    @PutMapping("/addproduct/{accountid}/{productid}")
    public Cart saveProductInCart(@PathVariable Long accountid, @PathVariable Long productid) throws Exception {
        cartServiceImpl.saveProductToCart(accountid,productid);
        return cartServiceImpl.addProductToCart(cartServiceImpl.getProductsFromPersistency(accountid),accountid);
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


    public void removedProduct(Product product, Cart cart) {

    }
}


