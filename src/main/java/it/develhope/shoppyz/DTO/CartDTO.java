package it.develhope.shoppyz.DTO;


public class CartDTO {

    private int id;

    private int  product_id;

    private int quantity;

    public CartDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return product_id;
    }

    public void setProductid(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
