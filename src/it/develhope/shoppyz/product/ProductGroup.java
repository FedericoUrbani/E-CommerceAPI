package it.develhope.shoppyz.product;

import java.util.ArrayList;

public class ProductGroup {
    private ArrayList<Product> products;

    public ProductGroup() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
