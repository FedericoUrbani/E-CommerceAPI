package it.develhope.shoppyz.database;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.user.User;

public class Database {

    // new
    private User user ;
    private Product product ;
    private Database database ;

    public void create() {
        // logica per creare un nuovo utente o prodotto nel database
    }

    public void readUser(User user) {
        // logica per leggere le informazioni di un utente dal database
        user.toString();
        // assegna le informazioni lette dal database all'oggetto user

    }


    public void  readProduct(Product product) {
        // logica per leggere le informazioni di un utente dal database
        product.toString();
        // assegna le informazioni lette dal database all'oggetto user

    }

    public void update() {
        // logica per aggiornare le informazioni dell'utente o del prodotto nel database
    }

    public void delete() {
        // logica per eliminare l'utente o del prodotto dal database
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }


}
