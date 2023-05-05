package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.DTO.Account.Account_DTO;
import it.develhope.shoppyz.DTO.Cart.CART_DTO_ADD;
import it.develhope.shoppyz.entity.Cart;
import it.develhope.shoppyz.repository.CartRepository;
import it.develhope.shoppyz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
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

    }





    //get all cart item for a user





    //delete a cart item for a user


