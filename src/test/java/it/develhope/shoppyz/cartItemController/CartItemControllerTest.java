package it.develhope.shoppyz.cartItemController;

import it.develhope.shoppyz.Controller.CartItemController;
import it.develhope.shoppyz.product.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import it.develhope.shoppyz.cartitem.CartItem;
import it.develhope.shoppyz.cartitem.CartItemService;
import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartItemController.class)
public class CartItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartItemService cartItemService;


    /**
     * Il primo test verifica il comportamento del metodo addCartItem nel CartItemController quando viene invocata una richiesta POST per aggiungere un elemento al carrello.
     * non avendo un return stiamo semplicemente verificando che il metodo saveCartItem nel service sia stato chiamato correttamente durante l'esecuzione della richiesta POST
     */
    @Test
    public void testAddCartItem() throws Exception {


        // richiesta POST
        mockMvc.perform(post("/Shoppyz/cartitem/addproduct/{accountid}/{productid}/{quantity}", anyLong(), anyLong(), anyInt())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // verifica che il mock sia chiamato
        verify(cartItemService, times(1)).saveCartItem(anyLong(), anyLong(), anyInt());
    }


    /**
     * Il secondo test verifica il comportamento del metodo getAllProductsByAccount nel CartItemController quando viene invocata una richiesta GET per ottenere tutti i prodotti nel carrello di un account
     * qui sono presenti dei dati fittizzi per emulare dei possibili account, prodotti e oggetti nel carrello.
     */

    @Test
    public void testGetAllProductsByAccount() throws Exception {
        // dati test
        Account account = new Account(1L, "Account 1", "Surname 1", null, "123456789", (byte) 1, "email@example.com", "password", null);
        Product product = new Product(1L, "Prodotto 1", "Brand 1", "Descrizione prodotto", 10.0, Category.Elettronica);
        CartItem cartItem = new CartItem(1L, account, product, 2);
        List<CartItem> cartItems = Arrays.asList(cartItem);

        // servizio mock
        when(cartItemService.getAllCartItemsByAccount(anyLong())).thenReturn(cartItems);

        // richiesta GET
        mockMvc.perform(get("/Shoppyz/cartitem/findallproduct/{accountid}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].account.id").value(1))
                .andExpect(jsonPath("$[0].account.name").value("Account 1"))
                .andExpect(jsonPath("$[0].account.surname").value("Surname 1"))
                .andExpect(jsonPath("$[0].product.id").value(1))
                .andExpect(jsonPath("$[0].product.name").value("Prodotto 1"))
                .andExpect(jsonPath("$[0].product.brand").value("Brand 1"))
                .andExpect(jsonPath("$[0].quantity").value(2));

        // verifica che il mock sia chiamato
        verify(cartItemService, times(1)).getAllCartItemsByAccount(anyLong());
    }
}
