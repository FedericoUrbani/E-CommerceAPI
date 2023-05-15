package it.develhope.shoppyz.order;

import it.develhope.shoppyz.account.Account;
import it.develhope.shoppyz.product.Category;
import it.develhope.shoppyz.product.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account buyerAccount;

    @Column
    private String trackingNumber;

    @OneToMany(mappedBy = "order_id", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    private List<Product> productsList = new ArrayList<>();

    @Column
    private byte isgift;

    @Column(name = "Date")
    private Date createDate;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order(){

    }

    public Order(int id, Account buyerAccount, String trackingNumber, List<Product> productsList, byte isgift, Date createDate, OrderStatus orderStatus) {
        this.id = id;
        this.buyerAccount = buyerAccount;
        this.trackingNumber = trackingNumber;
        this.productsList = productsList;
        this.isgift = isgift;
        this.createDate = createDate;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(Account buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
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
}
