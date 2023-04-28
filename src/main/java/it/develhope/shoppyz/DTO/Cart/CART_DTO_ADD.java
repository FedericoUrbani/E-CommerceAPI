package it.develhope.shoppyz.DTO.Cart;
import org.jetbrains.annotations.NotNull;

public class CART_DTO_ADD {

    private int id;
    @NotNull
    private int  product_id;
    @NotNull
    private int quantity;

    public CART_DTO_ADD() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
