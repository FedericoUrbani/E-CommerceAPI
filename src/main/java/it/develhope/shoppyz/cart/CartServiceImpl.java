package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.DTO.ProductDTO;
import it.develhope.shoppyz.relationProdCart.CartProduct;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.product.ProductRepository;
import it.develhope.shoppyz.relationProdCart.CartProductRepository;
import it.develhope.shoppyz.relationProdCart.CartProductServiceImpl;
import it.develhope.shoppyz.utils.ProductDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository ;
    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    CartProductServiceImpl cartProductServiceImpl;

    @Autowired
    ProductDTOConverter productDTOConverter;

    @Override
    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getCart(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public Cart findById(Long id) {
        return  cartRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCart(Long id) {
        cartRepository.deleteById(id);
    }

    /** estrapola la lista dei prodotti in dto **/
    public List<ProductDTO> getProductsFromPersistency(Long id){
        Cart cart=cartRepository.getReferenceById(id);
        List<Product> prodList= cartProductRepository.getListOfProductInCart(cart);
        return cartProductServiceImpl.getProductAsDTO(prodList);
    }

    /** salva la relazione nella fact table **/
    @Override
    public Cart saveProductToCart(Long accountid, Long productid) throws Exception {
        Cart cart=cartRepository.findById(accountid).orElseThrow(()->new Exception("Cart with id: "+accountid+" not found"));
        Product product= productRepository.getReferenceById(productid);
        CartProduct cartProduct= new CartProduct(cart,product);
        cartProductRepository.save(cartProduct);

        return cart;
    }
    /** aggiunge il prodotto alla lista embedded nel carrello **/
    public Cart addProductToCart(List<ProductDTO> listOfProd, Long cartId){
        Cart cart= cartRepository.getReferenceById(cartId);
        List<ProductsInCart> prodList=new ArrayList<>();
        for(ProductDTO p: listOfProd){
            prodList.add(productDTOConverter.convertProductToCartProduct(p));
        }
        cart.setProductList(prodList);
       // cart.setTotalPrice();
        return cart;
    }
    @Override
    public void saveCart(Cart cart) {
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void removedProduct(Product product, Long quantity) {

    }

    /** logica per autogenerazione trackingnumb */

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String randomTrackingNumberGenerator(){

        StringBuilder buffer = new StringBuilder(12);
        buffer.append("IT");
        for(int i = 0; i< 10; i++){
            int r= getRandomNumber(1,2);
            if(r==1)
            buffer.append((char) getRandomNumber(48,57));
            if(r==2)
            buffer.append((char) getRandomNumber(65,90));
        }
        String returnedString= buffer.toString();
        return returnedString;
    }

}
