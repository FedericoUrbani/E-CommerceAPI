package it.develhope.shoppyz.entity;

import java.util.ArrayList;

public class Product {
    private String id;
    private String type;
    private double price;
    private String image;
    private String stockedAmount;

    public Product(String id, String type, double price, String image, String stockedAmount) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.image = image;
        this.stockedAmount = stockedAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStockedAmount() {
        return stockedAmount;
    }

    public void setStockedAmount(String stockedAmount) {
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


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", stockedAmount='" + stockedAmount + '\'' +
                '}';


    }
}

