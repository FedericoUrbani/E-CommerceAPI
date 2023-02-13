package it.develhope.shoppyz.product;

public class Product extends ProductGroup{
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
}
