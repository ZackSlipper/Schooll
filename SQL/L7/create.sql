CREATE DATABASE ads_app;
USE ads_app;

CREATE TABLE users (
user_id SMALLINT AUTO_INCREMENT PRIMARY KEY, 
name varchar(20) NOT NULL,
email varchar(30) NOT NULL,
paswd varchar(20) NOT NULL);

CREATE TABLE categories (
	cat_id SMALLINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30) NOT NULL);

INSERT INTO users VALUES (0, "Jonas", "jonas@hotmail.com", "123456"), (0, "Ona", "ona@kitm.lt", "12345678"), (0, "Antanas", "antanas@gmail.com", "09876"), (0, "Zita", "zita@gmail.com", "098765")

INSERT INTO categories VALUES (0, "Baldai"), (0, "Elektronika"), (0, "Irankiai"), (0, "Drabuziai"), (0, "Maistas"), (0, "Kita");

SELECT * FROM users;
SELECT * FROM categories;

CREATE TABLE ads (
	ad_id SMALLINT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(45) NOT NULL,
	description VARCHAR(100) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	user_id SMALLINT,
	cat_id SMALLINT,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (cat_id) REFERENCES categories(cat_id));

ALTER TABLE ads ADD ad_time TIMESTAMP;

INSERT INTO ads VALUES (0, "Suknele", "Maza", 25.99, 2, 4, NOW()), (0, "Kede", "Medine", 50.00, 1, 1, NOW()), (0, "Televizorius", "Samsung", 1999.99, 3, 2, NOW()), (0, "Kepurė", "Juoda", 10.57, 4, 4, NOW()), (0, "Kavos pupelės", "Arabika", 5.00, 2, 5, NOW()), (0, "Kampinis šlifuoklis", "Bosch", 100.00, 3, 3, NOW()), (0, "Knyga", "Noubodi", 5.00, 1, 6, NOW());

SELECT a.title, a.description, c.name, a.price FROM ads AS a
INNER JOIN categories AS c ON a.cat_id = c.cat_id;

-- Get ad count for each category
-- Find only those categories that have more than 1 ad
SELECT c.name, COUNT(a.ad_id) AS ad_count FROM ads AS a
INNER JOIN categories AS c ON a.cat_id = c.cat_id
GROUP BY c.name
HAVING ad_count > 1;

-- Get only users that have more than 1 ad and their average ad price is more than 50
SELECT u.name, COUNT(a.ad_id) AS ad_count, AVG(a.price) AS avg_price FROM users AS u
JOIN ads AS a ON u.user_id = a.user_id
GROUP BY u.user_id
HAVING ad_count > 1 AND avg_price > 50;

-- Get average, min and max ad price
SELECT AVG(price) AS avg_price, MIN(price) AS min_price, MAX(price) AS max_price FROM ads;


-- UZDUOTYS

--Įterpti naują naudotoją su vardu "Rita", el. paštu "rita@gmail.com" ir slaptažodžiu "abc123".

INSERT INTO users VALUES (0, "Rita", "rita@gmail.com", "abc123");

--Atnaujinti naudotojo "Ona" el. paštą į "ona@newmail.com".

UPDATE users SET email = "ona@newmail.com" WHERE name = "Ona";

--Įterpti naują kategoriją „Automobiliai“.

INSERT INTO categories VALUES (0, "Automobiliai");

--Pridėti naują skelbimą apie „Kompiuterį“, kurio kaina yra 499.99, naudotojas yra „Jonas“, o kategorija – „Elektronika“ (turėtų egzistuoti jūsų kategorijų sąraše).

INSERT INTO ads VALUES (0, "Kompiuteris", "Zaidimams", 499.99, 1, 2, NOW());


-- Gauti pilną informaciją apie skelbimą, kurį patalpino konkretus sistemos naudotojas, pvz. id=2;

SELECT a.ad_id, a.title, a.description, a.price, a.ad_time, c.name AS cat_name, a.cat_id, u.name AS user_name, a.user_id FROM ads AS a
INNER JOIN categories AS c ON a.cat_id = c.cat_id
INNER JOIN users AS u ON a.user_id = u.user_id
WHERE a.user_id = 2;

-- Gauti visus vartotojus, kurių el. pašto domenas yra „gmail.com“.

SELECT * FROM users WHERE email LIKE "%gmail.com";

-- Ištraukti visus skelbimus, kuriuose pavadinime yra „SUKNELE“ (naudojant LIKE).

SELECT * FROM ads WHERE title LIKE "%SUKNELE%";

-- Rasti visas kategorijas, kurių pavadinimas prasideda raide „B“.

SELECT * FROM categories WHERE name LIKE "B%";

-- Išgauti skelbimus, kurių kaina viršija 100.

SELECT * FROM ads WHERE price > 100;