USE sakila;

-- Gauti nepasikartojančias filmų pakeitimo kainas suapvalintas iki sveikųjų skaičių, stulpelio pavadinimas “Pakeitimo kaina”
SELECT DISTINCT ROUND(replacement_cost, 0) AS "Pakeitimo Kaina" FROM film;

-- Gauti filmų pavadinimus didžiosiomis raidėmis, o filmų aprašymus mažosiomis.
SELECT upper(title) AS "Pavadinimas", lower(description) AS "Aprasymas" FROM film;

-- Rasti tik tuos filmus, kurie priklauso “Trailers” kategorijai (special_features stulpelis).
SELECT title, special_features FROM film WHERE special_features LIKE "%Trailers%";

-- Rasti filmus, kuriuos galima išsinuomoti 6 arba 7 dienoms.
SELECT title, rental_duration FROM film WHERE rental_duration IN (6, 7);

-- Rasti mažiausią / didžiausią filmo pakeitimo kainą.
SELECT min(replacement_cost), max(replacement_cost) FROM film;

-- Rasti filmą, kurio trukmė patenka į intervalą [70-100].
SELECT title, length FROM film WHERE length BETWEEN 70 AND 100;

-- Rasti filmus, kurių rating yra NC-17, PG, G.
SELECT title, rating FROM film WHERE rating IN ("NC-17", "PG", "G");

-- Gauti visus adresus ir pašto kodus, kurie priklauso “Buenos Aires” ir “Binar”  (stulpelis district).
SELECT address, postal_code FROM address WHERE district IN ("Buenos Aires", "Binar");

-- Kiek adresų yra skirtinguose rajonuose? (stulpelis district)
-- Sukurti ataskaitą:
SELECT district, count(*) AS count FROM address GROUP BY district ORDER BY count DESC;

-- Koks klientės LISA ANDERSON elektroninis paštas?
SELECT email FROM customer WHERE first_name = "LISA" AND last_name = "ANDERSON";

-- Kiek kuris klientas išleido nuomai?
SELECT customer.first_name, customer.last_name, sum(amount) FROM customer
LEFT JOIN payment ON customer.customer_id = payment.customer_id
GROUP BY customer.customer_id;

-- Kokios įplaukos už filmų nuomą gautos 2005-06-15?
SELECT sum(amount) FROM payment WHERE payment_date LIKE "2005-06-15%";
SELECT sum(amount) FROM payment WHERE DATE(payment_date) = "2005-06-15";

-- Rasti didžiausią ir mažiausią apmokėjimą įvykusį 2006-02-14.
SELECT max(amount), min(amount) FROM payment WHERE DATE(payment_date) = "2006-02-14";

-- Kiek apmokėjimų užfiksavo, gavo kiekvienas personalo darbuotojas?
SELECT first_name, last_name, count(payment_id) AS Kiekis FROM staff
INNER JOIN payment ON staff.staff_id = payment.staff_id
GROUP BY payment.staff_id;

-- Kokią apmokėjimų sumą užfiksavo, gavo kiekvienas personalo darbuotojas?
SELECT first_name, last_name, sum(amount) AS Suma FROM staff
INNER JOIN payment ON staff.staff_id = payment.staff_id
GROUP BY payment.staff_id;

-- Kiek mažiausiai / kiek daugiausiai už filmo nuomą yra sumokėjusi klientė Sarah Lewis? Naudokite lenteles “payment”, “customer”. Užklausa (1 eilutė).
SELECT min(amount), max(amount) FROM payment INNER JOIN customer
ON payment.customer_id = customer.customer_id
WHERE first_name = "SARAH" AND last_name = "LEWIS";

-- Surasti filmų pavadinimus, kurie priskiriami  "Sci-Fi"  kategorijai. Naudokite lenteles film, film_category, category lenteles. 
SELECT film.title from film INNER JOIN film_category
ON film.film_id = film_category.film_id INNER JOIN category
ON film_category.category_id = category.category_id WHERE category.name = "Sci-Fi";

-- Surasti filmus, kuriuose vaidino vaidino Cate Harris. Naudokite lenteles film, film_actor, actor lenteles.
SELECT film.title from film INNER JOIN film_actor
ON film.film_id = film_actor.film_id INNER JOIN actor
ON film_actor.actor_id = actor.actor_id
WHERE actor.first_name = "CATE" AND actor.last_name = "HARRIS";