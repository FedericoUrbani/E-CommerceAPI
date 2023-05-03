package it.develhope.shoppyz.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String brand;
    private String type;
    private double price;
    private int stockedAmount;

    public Product(int id, String name, String brand, String type, double price, int stockedAmount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.stockedAmount = stockedAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockedAmount() {
        return stockedAmount;
    }

    public void setStockedAmount(int stockedAmount) {
        this.stockedAmount = stockedAmount;
    }

   //Array list productGroups
    private ArrayList<Product> productGroups;

    public void ProductGroup() {
        productGroups = new ArrayList<Product>();
    }

    public void addProductGroup(Product productGroup) {
            productGroups.add(productGroup);
        }

    public ArrayList<Product> getProductGroups() {
        return productGroups;
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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", stockedAmount='" + stockedAmount + '\'' +
                ", productGroups=" + productGroups +
                '}';
    }

}

