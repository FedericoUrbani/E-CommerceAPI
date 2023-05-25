package it.develhope.shoppyz.cartitem;

import it.develhope.shoppyz.product.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.account.AccountService;
import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductService;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CartItemServiceTest {
    @Mock
    private AccountService accountService;

    @Mock
    private ProductService productService;

    @Mock
    private CartItemRepository cartItemRepository;

    private CartItemService cartItemService;

    @BeforeEach
    public void setup() {
        cartItemService = new CartItemService();
        cartItemService.accountService = accountService;
        cartItemService.productService = productService;
        cartItemService.cartItemRepository = cartItemRepository;
    }

    @Test
    public void testSaveCartItem() {
        Long accountId = 1L;
        Long productId = 2L;
        int quantity = 3;

        Account account = new Account();
        Product product = new Product();
        CartItem cartItem = new CartItem();

        when(accountService.getAccount(accountId)).thenReturn(account);
        when(productService.getProduct(productId)).thenReturn(product);
        when(cartItemRepository.saveAndFlush(any(CartItem.class))).thenReturn(cartItem);

        cartItemService.saveCartItem(accountId, productId, quantity);

        verify(accountService, times(1)).getAccount(accountId);
        verify(productService, times(1)).getProduct(productId);
        verify(cartItemRepository, times(1)).saveAndFlush(any(CartItem.class));
    }



    @Test
    void getAllCartItemsByAccount() {

        CartItemService cartItemService = new CartItemService();
        cartItemService.cartItemRepository = cartItemRepository;


        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem());
        cartItems.add(new CartItem());

        Long accountId = 1L;


        when(cartItemRepository.findAllByAccountId(accountId)).thenReturn(cartItems);
        List<CartItem> result = cartItemService.getAllCartItemsByAccount(accountId);

        assertEquals(cartItems, result);

        verify(cartItemRepository).findAllByAccountId(accountId);
    }
}