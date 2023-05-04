package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.Api.ApiResponse;
import it.develhope.shoppyz.DTO.Account.Account_DTO;
import it.develhope.shoppyz.DTO.Cart.CART_DTO_ADD;
import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.repository.CartRepository;
import it.develhope.shoppyz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;


    //api add to cart
    @GetMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody CART_DTO_ADD cart_dto_add,@RequestBody Account_DTO accountDto){

            // Recupera l'ID dell'utente
            int account_id = accountDto.getId();

            // Carica il carrello dell'utente dall'ID utente recuperato.
            Cart cart = cartService.getCartByUserId(account_id);

            // Aggiungi l'oggetto al carrello dell'utente.
           // cart.addProduct(cart.getProductId(), cart_dto_add.getQuantity());

            // Salva il carrello dell'utente con gli oggetti aggiunti.
            cartService.saveCart(cart);



          //  return new ResponseEntity<>(new ApiResponse(true,"Added to cart"), HttpStatus.CREATED);
            return null;
        }

    }





    //get all cart item for a user





    //delete a cart item for a user


