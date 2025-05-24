USE sakila;

-- Rasti parduotuvės ID ir vardus, pavardes ten dirbančio personalo. (Store, Staff lentelės)
SELECT store.store_id, first_name, last_name FROM store
INNER JOIN staff ON staff.store_id = store.store_id;

-- Rasti informaciją apie visus klientus ir jų mokėjimus. Naudoti (customer, payment) 
SELECT first_name, last_name, amount FROM customer
INNER JOIN payment ON customer.customer_id = payment.customer_id;

-- Rasti informaciją apie visus klientus ir jų mokėjimų sumas, rezultatą grupuojant pagal klientus, o surikiuojant pagal apmokėjimų sumas nuo didžiausios iki mažiausios. Naudoti (customer, payment)

SELECT first_name, last_name, SUM(amount) as total_amount FROM customer
INNER JOIN payment ON customer.customer_id = payment.customer_id
GROUP BY customer.customer_id
ORDER BY total_amount DESC;

-- Parašykite SQL užklausą, kuri pateikia sąrašą su pardavėjo vardu ir pavarde, kliento vardu ir pavarde, ir parduotuvės ID, kuriai priklauso ir pardavėjas, ir klientas. (Staff ir Customer lentelės)

SELECT staff.first_name, staff.last_name, customer.first_name, customer.last_name, staff.store_id FROM staff
INNER JOIN customer ON staff.store_id = customer.store_id;

-- Pateikite Graikijoje gyvenančių klientų vardą, pavardę ir miesto pavadinimą. Naudokite customer, address, city, country lenteles.

SELECT first_name, last_name, city FROM customer
INNER JOIN address ON customer.address_id = address.address_id
INNER JOIN city ON address.city_id = city.city_id
INNER JOIN country ON city.country_id = country.country_id
WHERE country = 'Greece';

-- Kiek klientė Amy Lopez sumokėjo už filmo Rocky War nuomą? Galima išspręsti tiek su inner join, tiek su subužklausa.  Naudokite customer, payment, rental, inventory, film lenteles.

-- Su subqueries
SELECT SUM(payment.amount) FROM payment WHERE payment.rental_id IN
(SELECT rental.rental_id FROM rental WHERE rental.inventory_id IN
(SELECT inventory_id FROM inventory WHERE inventory.film_id IN
(SELECT film_id FROM film WHERE title = 'Rocky War')))
AND payment.customer_id IN
(SELECT customer_id FROM customer WHERE first_name = 'Amy' AND last_name = 'Lopez');

-- Be subqueries
SELECT SUM(payment.amount) FROM payment
INNER JOIN rental ON payment.rental_id = rental.rental_id
INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id
INNER JOIN film ON inventory.film_id = film.film_id
INNER JOIN customer ON payment.customer_id = customer.customer_id
WHERE customer.first_name = 'Amy' AND customer.last_name = 'Lopez' AND film.title = 'Rocky War';

-- Kiek iš viso kiekvienoje šalyje yra išleidžiama filmų nuomai? Naudokite payment, customer, address, city, country lenteles.

SELECT country.country, SUM(amount) FROM payment
INNER JOIN customer ON payment.customer_id = customer.customer_id
INNER JOIN address ON customer.address_id = address.address_id
INNER JOIN city ON address.city_id = city.city_id
INNER JOIN country ON city.country_id = country.country_id
GROUP BY country.country;

-- Kiek nuomos užsakymų įvykdė darbuotojas Mike Hillyer per 2005 metų liepos mėnesį?

SELECT COUNT(rental_id) FROM rental
INNER JOIN staff ON rental.staff_id = staff.staff_id
WHERE staff.first_name = 'Mike' AND staff.last_name = 'Hillyer' AND rental_date LIKE '2005-07-%';

SELECT COUNT(rental_id) FROM rental
INNER JOIN staff ON rental.staff_id = staff.staff_id
WHERE staff.first_name = 'Mike' AND staff.last_name = 'Hillyer' AND rental_date BETWEEN '2005-07-01' AND '2005-08-01';

-- Kiek nuomos užsakymų įvykdė darbuotojas Jon Stephens per 2005 metų gegužės mėnesį?

SELECT COUNT(rental_id) FROM rental
INNER JOIN staff ON rental.staff_id = staff.staff_id
WHERE staff.first_name = 'Jon' AND staff.last_name = 'Stephens' AND rental_date LIKE '2005-05-%';

-- Kiek kiekvienoje kategorijoje yra filmų?

SELECT category.name, COUNT(film.film_id) FROM category
INNER JOIN film_category ON category.category_id = film_category.category_id
INNER JOIN film ON film_category.film_id = film.film_id
GROUP BY category.category_id;

--Kada paskutinį kartą buvo išnuomotas filmas „BABY HALL”? (rental, inventory, film).

SELECT MAX(rental_date) FROM rental INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id
INNER JOIN film ON inventory.film_id = film.film_id
WHERE film.title = 'BABY HALL';
-- ORDER BY rental_date DESC LIMIT 1;

--Kada buvo išnuomotas filmas „GREATEST NORTH”? (rental, inventory, film).

SELECT rental_date FROM rental INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id
INNER JOIN film ON inventory.film_id = film.film_id
WHERE film.title = 'GREATEST NORTH';