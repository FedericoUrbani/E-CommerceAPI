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
/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
*/

    @Column(name = "Date")
    private Date createDate;

    @Column(name = "quantity")
    private int quantity;


    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getQuantity() {
        return quantity;
    }


    public Cart(int id, Date createDate, int quantity) {
        this.id = id;
        this.createDate = createDate;
        this.quantity = quantity;
    }
}
