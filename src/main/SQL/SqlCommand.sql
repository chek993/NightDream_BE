DROP DATABASE IF EXISTS NIGHTDREAM;

CREATE DATABASE NIGHTDREAM CHARACTER SET utf8 COLLATE utf8_general_ci;

USE NIGHTDREAM;

CREATE TABLE Proprietario(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	cognome VARCHAR(255) NOT NULL,
	data_nascita DATE,
	num_telefono VARCHAR(255),
	email VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE Cliente(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	cognome VARCHAR(255) NOT NULL,
	data_nascita DATE,
	num_telefono VARCHAR(255),
	email VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE Appartamento(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	proprietario_id INT(11) NOT NULL,
	nome VARCHAR(255) UNIQUE NOT NULL,
	indirizzo VARCHAR(255) NOT NULL,
	num_camere INT(3) NOT NULL DEFAULT 0,
	num_bagni INT(3) NOT NULL DEFAULT 0,
	posti_letto INT(3) NOT NULL DEFAULT 0,
	prezzo DOUBLE(8,2) NOT NULL DEFAULT 0.00,
	cucina BIT(1) DEFAULT 0,
	televisione BIT(1) DEFAULT 0,
	bagno_camera BIT(1) DEFAULT 0,
	FOREIGN KEY (proprietario_id) REFERENCES Proprietario(id)
);

CREATE TABLE Prenotazione(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	cliente_id INT(11) NOT NULL,
	appartamento_id INT(11) NOT NULL,
	creation_time DATETIME NOT NULL,
	data_inizio DATE NOT NULL,
	data_fine DATE NOT NULL,
	pagato BIT(1) DEFAULT 0,
	metodo_pagamento VARCHAR(255) DEFAULT '',
	FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
	FOREIGN KEY (appartamento_id) REFERENCES Appartamento(id)
);