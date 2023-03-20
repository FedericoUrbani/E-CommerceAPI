package it.develhope.shoppyz.entity;

public class Order {
    private int id;

    private int userId;

    private String trackingNumber;
    private int numberOfItems;

    private String address;
    private int isgift;

    public Order(int id, int userId, String trackingNumber, int numberOfItems, String address, int isgift) {
        this.id = id;
        this.userId = userId;
        this.trackingNumber = trackingNumber;
        this.numberOfItems = numberOfItems;
        this.address = address;
        this.isgift = isgift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsgift() {
        return isgift;
    }

    public void setIsgift(int isgift) {
        this.isgift = isgift;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", address='" + address + '\'' +
                ", isgift=" + isgift +
                '}';
    }
}
