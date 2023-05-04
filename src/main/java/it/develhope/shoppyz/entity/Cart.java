package it.develhope.shoppyz.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Date")
    private Date createDate;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="User_id")
    private Account account;

    /*@ManyToOne
    @JoinColumn(name="Product_id")*/
    private Product product;



    private double totalPrice;
    private PaymentMethod paymentMethod;


    List<Product> productList = new ArrayList<>();
    List<Integer> quantities = new ArrayList<>();


    public Cart(Product product, double totalPrice, PaymentMethod paymentMethod) {
        this.product = product;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public int getProductId(int productId) {
        for (Product product : productList) {
            if (product.getId()==productId) {
                return product.getId();
            }
        }
        return Integer.parseInt(null);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }


}
