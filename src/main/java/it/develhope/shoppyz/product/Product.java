package it.develhope.shoppyz.product;


import it.develhope.shoppyz.cart.Cart;
import it.develhope.shoppyz.facts.Cart_product;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "product")
    Set<Cart_product> registrations;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column
    private String description;

    @Column(nullable = false)
    private double price;


    @Column
    @Enumerated(EnumType.STRING)
    private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Cart_product> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Cart_product> registrations) {
        this.registrations = registrations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

