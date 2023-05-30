package it.develhope.shoppyz.Controller;


import it.develhope.shoppyz.cartitem.CartItem;
import it.develhope.shoppyz.cartitem.CartItemDTO;
import it.develhope.shoppyz.cartitem.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{accountId}/product/{productId}")
    public ResponseEntity<?> removeCartItem(
            @PathVariable Long accountId,
            @PathVariable Long productId,
            @RequestParam(value = "quantity", defaultValue = "1") int quantityToRemove
    ) {
        try {
            cartItemService.removeCartItem(accountId, productId, quantityToRemove);
            CartItemDTO cartItemDTO = cartItemService.getActualCart(accountId);
            return ResponseEntity.ok().body(cartItemDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Il cart adesso è vuoto o il prodotto da voler togliere non esiste");
        }
    }
}

