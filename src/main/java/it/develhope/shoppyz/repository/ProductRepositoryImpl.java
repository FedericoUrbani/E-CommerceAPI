package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product getProduct(String id) {
        //prendere un prodotto
        return null;
    }

    @Override
    public void postProduct(Product product) {
        //aggiungere un prodotto
    }

    @Override
    public void updateProduct(String id) {
        //modificare un prodotto
    }

    @Override
    public void deleteProduct(String id) {
        //cancellare un prodotto
    }

    @Override
    public List<Product> getProduct(List<Product> products) {
        //prende la lista di ogni prodotto nel database
        return null;
    }
}
