package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.cart.CartServiceImpl;
import it.develhope.shoppyz.relationProdCart.Cart_ProductRepository;
import it.develhope.shoppyz.relationProdCart.Cart_ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Shoppyz/cart")
public class CartController {

    @Autowired
    private Cart_ProductServiceImpl cartProductServiceImpl;
    @Autowired
    private CartServiceImpl cartServiceImpl;

    @GetMapping("/{id}")
    public List<Product>getProductsFromCart(@PathVariable Long id){
        return cartProductServiceImpl.getProductsInCart(id);
    }

    @GetMapping("/findall")
    public List<Cart> findAll() {
        return cartServiceImpl.findAllCart();
    }

    @GetMapping(value = "/findCartbyid/{id}")
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return cartServiceImpl.getCart(id);
    }


    @PutMapping("{accountid}/{productid}")
    public void addProductInCart(@PathVariable Long accountid, @PathVariable Long productid) throws Exception {
        cartServiceImpl.addProductToCart(accountid,productid);
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


