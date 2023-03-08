DROP DATABASE shoppyzdb;
CREATE DATABASE IF NOT EXISTS shoppyzdb;
USE shoppyzdb;
CREATE TABLE IF NOT EXISTS products(id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (20),
brand VARCHAR (20),
type VARCHAR (20),
price DOUBLE,
stockedAmount INT
);

INSERT INTO products(name, brand, type, price, stockedAmount) VALUE ('divisa Roma', 'Nike', 'abbigliamento', 100, 20);
INSERT INTO products(name, brand, type, price, stockedAmount) VALUE ('divisa Milan', 'Puma', 'abbigliamento', 100, 20);
INSERT INTO products(name, brand, type, price, stockedAmount) VALUE ('divisa Inter', 'Nike', 'abbigliamento', 100, 20);
INSERT INTO products(name, brand, type, price, stockedAmount) VALUE ('Air Force', 'Nike', 'scarpe', 94.99 , 50);
INSERT INTO products(name, brand, type, price, stockedAmount) VALUE ('Dunk High', 'Nike', 'scarpe', 119.99 , 30);


