package it.develhope.shoppyz.Controller;



import it.develhope.shoppyz.DTO.ProductDTO;
import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.cart.CartServiceImpl;
import it.develhope.shoppyz.relationProdCart.CartProduct;
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
    public List<ProductDTO>getProductsFromCart(@PathVariable Long id) throws Exception {
        Cart cart=cartServiceImpl.getCart(id).orElseThrow(()->new Exception("Cart with id: "+id+" not found"));
        List<Product> prodList= cartProductRepository.getListOfProductInCart(cart);
        return cartProductServiceImpl.getProductasDTO(prodList);
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


