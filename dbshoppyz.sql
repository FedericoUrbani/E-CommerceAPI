-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.28 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.4.0.6659
-- --------------------------------------------------------

DROP DATABASE shoppyzdb;

-- Dump della struttura del database shoppyzdb
CREATE DATABASE IF NOT EXISTS `shoppyzdb`;
USE `shoppyzdb`;

-- Dump della struttura di tabella shoppyzdb.accounts
CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `sellsactivation` tinyint DEFAULT NULL,
  `isenabled` tinyint DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella shoppyzdb.accounts: ~4 rows (circa)
DELETE FROM `accounts`;
INSERT INTO `accounts` (`id`, `name`, `password`, `sellsactivation`, `isenabled`, `email`) VALUES
	(1, 'Alfred88', 'password', 0, 1, 'alfred@gmail.com'),
	(2, 'JessicaRab', 'password', 0, 1, 'jessichetta@gmail.com'),
	(3, 'Alice', 'password', 0, 1, 'alice23@gmail.com'),
	(4, 'user4000', 'password', 0, 1, 'user4000@gmail.com');

-- Dump della struttura di tabella shoppyzdb.products
CREATE TABLE IF NOT EXISTS `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stockedAmount` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella shoppyzdb.products: ~5 rows (circa)
DELETE FROM `products`;
INSERT INTO `products` (`id`, `name`, `brand`, `type`, `price`, `stockedAmount`) VALUES
	(1, 'divisa Roma', 'Nike', 'abbigliamento', 100, 20),
	(2, 'divisa Milan', 'Puma', 'abbigliamento', 100, 20),
	(3, 'divisa Inter', 'Nike', 'abbigliamento', 100, 20),
	(4, 'Air Force', 'Nike', 'scarpe', 94.99, 50),
	(5, 'Dunk High', 'Nike', 'scarpe', 119.99, 30);

-- Dump della struttura di tabella shoppyzdb.user
CREATE TABLE IF NOT EXISTS users (
  `id` int NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(50) NOT NULL DEFAULT '',
  `accountId` int NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '',
  `surname` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `accountId` (`accountId`),
  CONSTRAINT `accountfk` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella shoppyzdb.user: ~3 rows (circa)
DELETE FROM `users`;
INSERT INTO `users` (`id`, `phoneNumber`, `accountId`, `name`, `surname`, `address`) VALUES
	(1, '3343099768', 1, 'Alfred', 'Marchionne', 'Via Paolo Inglese, 34, 00679, Roma'),
	(2, '344567677', 2, 'Jessica', 'Rabbit', 'Via Federico Francese 37,00199,Roma'),
	(3, '3242545436', 3, 'Alice', 'Junior', 'Via Solcato 18, 12003, Venezia ');


