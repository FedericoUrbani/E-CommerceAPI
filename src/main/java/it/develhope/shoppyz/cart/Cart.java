package it.develhope.shoppyz.cart;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private byte isgift;
    @Column
    private double totalPrice;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ProductInCart", joinColumns = @JoinColumn(name = "cart_id"), foreignKey = @ForeignKey(name = "products_fk"))
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")),
            @AttributeOverride(name = "price", column = @Column(name = "price")),
    })
    private List<ProductsInCart> productList;

    public Cart(){}


    public Cart(Long id, byte isgift, double totalPrice, List<ProductsInCart> productList) {
        this.id = id;
        this.isgift = isgift;
        this.totalPrice = totalPrice;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getIsgift() {
        return isgift;
    }

    public void setIsgift(byte isgift) {
        this.isgift = isgift;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductsInCart> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductsInCart> productList) {
        this.productList = productList;
    }
}