-- Active: 1741027825782@@127.0.0.1@3306
CREATE DATABASE examen_web_dyn_s4_deploy;
-- INSERT INTO ligne_credit(libelle,montant) VALUES ('frais bus',12.0);
CREATE TABLE examen_web_dyn_s4_ligne_credit(
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(50) ,
    montant DECIMAL(10,2)
);

CREATE TABLE examen_web_dyn_s4_ligne_depense(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_ligne_credit INT,
    montant DECIMAL(10,2),
    date_insertion DATE,
    FOREIGN KEY (id_ligne_credit) REFERENCES examen_web_dyn_s4_ligne_credit(id)
);

CREATE TABLE examen_web_dyn_s4_users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    password VARCHAR(100)
);
INSERT INTO examen_web_dyn_s4_users (name,password) VALUES ('jean','jean');