package it.develhope.shoppyz.cartitem;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.account.AccountService;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CartItemService {

    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;
    @Autowired
    CartItemRepository cartItemRepository;

/** salva il prodotto nel carrello con una quantità specifico per il prodotto**/
    public void saveCartItem(Long accountid, Long productid, int quantity){
        CartItem cartItem= new CartItem();
        Account account=accountService.getAccount(accountid);
        Product product=productService.getProduct(productid);
        cartItem.setAccount(account);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.saveAndFlush(cartItem);

    }
/** estrae tutte le relazioni tra l'accountid e il prodotto messo nel carrello**/
    public List<CartItem> getAllCartItemsByAccount (Long accountid){
        List<CartItem> prodlist=cartItemRepository.findAllByAccountId(accountid);
        return prodlist;
    }

}
