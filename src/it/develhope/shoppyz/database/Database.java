package it.develhope.shoppyz.database;

import it.develhope.shoppyz.product.Product;
import it.develhope.shoppyz.user.User;

public class Database {

    private User user = new User();
    private Product product = new Product();
    private Database database = new Database(user, product);

    public void create() {
        // logica per creare un nuovo utente o prodotto nel database
    }

    public User readUser(int id) {
        // logica per leggere le informazioni di un utente dal database
        User user = new User();
        // assegna le informazioni lette dal database all'oggetto user
        return user;
    }


    public Product readProduct(int id) {
        // logica per leggere le informazioni di un utente dal database
        Product product = new Product();
        // assegna le informazioni lette dal database all'oggetto user
        return product;
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


    /*Istanza di:
    * -User:User;
    * -Product:Product;

    * Metodi database:
    * -create(); -> for User e Product
    * -read(); -> for User e Product
    * -update(); -> for User e Product
    * -delete(); -> for User e Product
    *
    * -getter/setter();
     */
}
