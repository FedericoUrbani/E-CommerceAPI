package it.develhope.shoppyz.cartitem;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.account.AccountService;
import it.develhope.shoppyz.order.OrderProduct;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductService;
import it.develhope.shoppyz.utils.OrderProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartItemService {

    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    OrderProductConverter orderProductConverter;

    /**
     * salva il prodotto nel carrello con una quantità specifico per il prodotto
     **/
    public void saveCartItem(Long accountid, Long productid, int quantity) {
        CartItem cartItem = new CartItem();
        Account account = accountService.getAccount(accountid);
        Product product = productService.getProduct(productid);
        cartItem.setAccount(account);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.saveAndFlush(cartItem);

    }

    /**
     * estrae tutte le relazioni tra l'accountid e il prodotto messo nel carrello
     **/
    public List<CartItem> getAllCartItemsByAccount(Long accountid) {
        List<CartItem> prodlist = cartItemRepository.findAllByAccountId(accountid);
        return prodlist;
    }

    public CartItemDTO getActualCart(Long accountid) {
        List<CartItem> prodlist = cartItemRepository.findAllByAccountId(accountid);
        CartItemDTO ciDTO = new CartItemDTO();
        ciDTO.setName(prodlist.get(0).getAccount().getName());
        ciDTO.setSurname(prodlist.get(0).getAccount().getSurname());
        List<OrderProduct> orderList = new ArrayList<>();
        for (CartItem ci : prodlist) {
            OrderProduct ordProd = orderProductConverter.convertProduct(ci.getProduct());
            ordProd.setQuantity(ci.getQuantity());
            double actualPrice = 0;
            for (int i = 0; i < ci.getQuantity(); i++) {
                actualPrice = actualPrice + ordProd.getPrice();
            }
            ordProd.setPrice(actualPrice);
            orderList.add(ordProd);
        }
        ciDTO.setProductInCart(orderList);
        double totalPrice = 0.0;
        for (OrderProduct p : ciDTO.productInCart) {
            totalPrice += p.getPrice();
        }
        ciDTO.setTotalprice(totalPrice);
        return ciDTO;
    }


    public void removeCartItem(Long accountId, Long productId, int quantityToRemove) {
        List<CartItem> cartItems = cartItemRepository.findAllByAccountId(accountId);

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(productId)) {
                int currentQuantity = cartItem.getQuantity();

                if (currentQuantity > quantityToRemove) {

                    cartItem.setQuantity(currentQuantity - quantityToRemove);
                    cartItemRepository.save(cartItem);
                } else {

                    cartItemRepository.delete(cartItem);
                }
                break;
            }
        }
    }
}
