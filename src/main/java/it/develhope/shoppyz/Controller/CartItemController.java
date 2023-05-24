package it.develhope.shoppyz.Controller;


import it.develhope.shoppyz.cartitem.CartItem;
import it.develhope.shoppyz.cartitem.CartItemDTO;
import it.develhope.shoppyz.cartitem.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Shoppyz/cartitem")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;


    @PostMapping("/addproduct/{accountid}/{productid}/{quantity}")
    public CartItemDTO addCartItem(@PathVariable Long accountid,
                                   @PathVariable Long productid,
                                   @PathVariable int quantity) {
        cartItemService.saveCartItem(accountid, productid, quantity);
        return cartItemService.getActualCart(accountid);
    }


    @GetMapping("/findallproduct/{accountid}")
    public List<CartItem> getAllProductsByAccount(@PathVariable Long accountid) {
        return cartItemService.getAllCartItemsByAccount(accountid);
    }


}