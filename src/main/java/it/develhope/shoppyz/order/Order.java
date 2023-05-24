package it.develhope.shoppyz.order;

import it.develhope.shoppyz.account.PaymentMethod;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    private Long accountId;

    @Column
    private String trackingNumber;

    @Column
    private byte isgift;

    @Column(name = "date")
    private Date createDate;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    @Column
    private double totaleprice;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "product_id"), foreignKey = @ForeignKey(name = "product_order_fk"))
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")),
            @AttributeOverride(name = "price", column = @Column(name = "price")),
    })
    private List<OrderProduct> productsOrder;

    public Order(Long id, String trackingNumber, byte isgift, Date createDate, OrderStatus orderStatus, Long accountId, double totaleprice, List<OrderProduct> productsOrder) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.isgift = isgift;
        this.createDate = createDate;
        this.orderStatus = orderStatus;
        this.accountId = accountId;
        this.totaleprice = totaleprice;
        this.productsOrder = productsOrder;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public byte getIsgift() {
        return isgift;
    }

    public void setIsgift(byte isgift) {
        this.isgift = isgift;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getTotaleprice() {
        return totaleprice;
    }

    public void setTotaleprice(double totaleprice) {
        this.totaleprice = totaleprice;
    }

    public List<OrderProduct> getProductsOrder() {
        return productsOrder;
    }

    public void setProductsOrder(List<OrderProduct> productsOrder) {
        this.productsOrder = productsOrder;
    }
}
