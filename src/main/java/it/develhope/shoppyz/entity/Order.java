package it.develhope.shoppyz.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String trackingNumber;

    @Column
    private byte isgift;

    @Column(name = "Date")
    private Date createDate;

    public Order(){

    }

    public Order(int id, String trackingNumber, byte isgift) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.isgift = isgift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }


    public byte isIsgift() {
        return isgift;
    }

    public void setIsgift(byte isgift) {
        this.isgift = isgift;
    }
}
