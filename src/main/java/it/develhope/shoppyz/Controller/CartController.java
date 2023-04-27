package it.develhope.shoppyz.Controller;

import it.develhope.shoppyz.Api.ApiResponse;
import it.develhope.shoppyz.DTO.Cart.CART_DTO_ADD;
import it.develhope.shoppyz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    //api add to cart

    public ResponseEntity<ApiResponse> addToCart(@RequestBody CART_DTO_ADD cart_dto_add){

        //manca l'associazione all'user che bisogna implementare, in qualche modo

        cartService.addToCart(cart_dto_add);

        return new ResponseEntity<>(new ApiResponse(true,"Added to cart"), HttpStatus.CREATED);

    }





    //get all cart item for a user





    //delete a cart item for a user

}
