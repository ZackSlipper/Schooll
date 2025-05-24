CREATE DATABASE sandelys;
USE sandelys;

CREATE TABLE kategorijos(
id SMALLINT auto_increment primary key,
pavadinimas VARCHAR(55) NOT NULL);

CREATE TABLE prekes(
id SMALLINT auto_increment primary key,
pavadinimas VARCHAR(55) NOT NULL,
aprasymas VARCHAR(255),
kiekis INT NOT NULL,
kaina FLOAT(10,2) NOT NULL,
irasimo_laikas TIMESTAMP);

INSERT INTO kategorijos VALUES (0, "Pieno Produktai"), (0, "Valymo Priemones"), (0, "Maisto Prekes");
INSERT INTO prekes VALUES
(0, "Pienas", "Saltas pienas", 10, 3.42, NOW()),
(0, "Malkos", "Tinks kurenimui", 500, 30.50, NOW()),
(0, "Grindu Valiklis", NULL, 87, 7.75, NOW()),
(0, "Sausainiai", "Traskus ir sviezi", 465, 1.64, NOW()),
(0, "Sviestas", "Sviestas is sviezio pieno", 1634, 4.18, NOW());

SELECT pavadinimas, aprasymas, kaina FROM prekes;