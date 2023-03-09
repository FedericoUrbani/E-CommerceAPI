\connect root@localhost;
DROP DATABASE shoppyzdb;
CREATE DATABASE IF NOT EXISTS shoppyzdb;
CREATE USER IF NOT EXISTS 'developer' IDENTIFIED BY 'developer1';
GRANT ALL PRIVILEGES ON shoppyzdb . * TO 'developer'@'localhost';
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


CREATE TABLE accounts(id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (20),
password VARCHAR (20),
sellsactivation TINYINT,
isenabled TINYINT,
email VARCHAR(30)
);

INSERT INTO accounts (name, password, sellsactivation, isenabled,email) VALUE ('Alfred88','password',0,1,'alfred@gmail.com');
INSERT INTO accounts (name, password, sellsactivation, isenabled,email) VALUE ('JessicaRab','password',0,1,'jessichetta@gmail.com');
INSERT INTO accounts (name, password, sellsactivation, isenabled,email) VALUE ('Alice','password',0,1,'alice23@gmail.com');
INSERT INTO accounts (name, password, sellsactivation, isenabled,email) VALUE ('user4000','password',0,1,'user4000@gmail.com');


