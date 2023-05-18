package it.develhope.shoppyz.cart;


import it.develhope.shoppyz.DTO.ProductDTO;
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
    private List<ProductDTO> productList;

    public Cart(){}


    public Cart(Long id, byte isgift, double totalPrice, List<ProductDTO> productList) {
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
        if(this.totalPrice==0&&this.productList!=null){
            this.totalPrice=0;
            for(ProductDTO p: this.productList){
                setTotalPrice(totalPrice+=p.getPrice());
            }
        }
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}