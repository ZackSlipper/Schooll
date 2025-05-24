USE sakila;

-- A.
-- Get countries starting with 'Uni...'
SELECT * FROM country WHERE country LIKE 'Uni%';

-- Get countries that have the symbols 'ia'
SELECT * FROM country WHERE country LIKE '%ia%';

-- Get countries that end in symbols '...land'
SELECT * FROM country WHERE country LIKE '%land';

-- Sort countries alphabetically
SELECT * FROM country ORDER BY country ASC;

-- Get staff
SELECT LOWER(CONCAT(first_name, " - ", last_name)) as Personalas FROM staff;


-- B.
-- All actor names
SELECT first_name, last_name FROM actor;

-- Movie categories
SELECT DISTINCT category_id FROM film_category GROUP BY category_id;

-- Films
SELECT * FROM film;

-- Sort actors by name
SELECT first_name, last_name FROM actor ORDER BY first_name, last_name ASC;

-- Sort movies by price
SELECT title, rental_rate FROM film ORDER BY rental_rate DESC;

-- Select movies with unique length
SELECT DISTINCT length, title FROM film;


-- C.
-- Select distinct actor names from the actor table
SELECT DISTINCT first_name, last_name FROM actor;

-- Select distinct movie rental rates from the film table
SELECT DISTINCT rental_rate FROM film;

-- Select from film table and name the title column as 'Filmo pavadinimas' and the description column as 'Filmo aprašymas'
SELECT title AS 'Filmo pavadinimas', description AS 'Filmo aprašymas' FROM film;

-- Count actors in the actor table
SELECT COUNT(first_name) FROM actor;

-- Count unique actor names in the actor table
SELECT COUNT(DISTINCT first_name) AS "Unikaliu vardu skaicius" FROM actor;

-- Count actor names in the actor table
SELECT first_name, COUNT(first_name) FROM actor GROUP BY first_name;