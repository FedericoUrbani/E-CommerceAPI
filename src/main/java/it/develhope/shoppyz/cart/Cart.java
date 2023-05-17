package it.develhope.shoppyz.cart;

import jakarta.persistence.*;



@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private byte isgift;

    public Cart( byte isgift) {


        this.isgift = isgift;
    }

    public Cart(){}


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
}