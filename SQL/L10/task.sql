--Kiek užsakymų padarė kiekvienas klientas?
SELECT first_name, last_name, COUNT(order_id) AS orders_count FROM orders
INNER JOIN customers ON orders.customer_id = customers.customer_id
GROUP BY orders.customer_id
ORDER BY orders_count DESC;

--Kiekvieno kliento bendra išleista suma už užsakymus.
SELECT first_name, last_name, SUM(total_price) AS total_spent FROM orders
INNER JOIN customers ON orders.customer_id = customers.customer_id
GROUP BY orders.customer_id
ORDER BY total_spent DESC;

--Kuris maistas yra populiariausias (daugiausiai užsakytas)?
SELECT item_name, SUM(quantity) AS quantity FROM food_items
INNER JOIN orders_items ON orders_items.item_id = food_items.item_id
GROUP BY orders_items.item_id
ORDER BY quantity DESC
LIMIT 1;

--Kuris restoranas turi daugiausiai užsakytų patiekalų?
SELECT restaurant_name, item_name, SUM(quantity) AS quantity FROM food_items
INNER JOIN orders_items ON orders_items.item_id = food_items.item_id
INNER JOIN restaurants ON food_items.restaurant_id = restaurants.restaurant_id
GROUP BY orders_items.item_id
ORDER BY quantity DESC
LIMIT 1;

--Vidutinė maisto kaina restoranuose.
SELECT restaurant_name, AVG(price) AS avg_price FROM food_items
INNER JOIN restaurants ON food_items.restaurant_id = restaurants.restaurant_id
GROUP BY restaurants.restaurant_id;

--Klientų, kurie užsakė daugiau nei 10 patiekalų, sąrašas.
SELECT first_name, last_name, COUNT(item_id) AS items_count FROM orders
INNER JOIN customers ON orders.customer_id = customers.customer_id
INNER JOIN orders_items ON orders.order_id = orders_items.order_id
GROUP BY orders.customer_id
HAVING items_count > 10
ORDER BY items_count DESC;

--Kiekvieno vairuotojo atliktų užsakymų skaičius.
SELECT drivers.name, COUNT(order_id) AS orders_count FROM orders
INNER JOIN drivers ON orders.driver_id = drivers.driver_id
GROUP BY orders.driver_id
ORDER BY orders_count DESC;

--Restoranai, kurie siūlo "vegetarian" maistą.
SELECT restaurant_name FROM food_items
INNER JOIN restaurants ON food_items.restaurant_id = restaurants.restaurant_id
WHERE food_type IN ('vegetarian', "VEG");

--Dienos, kai buvo atlikta daugiausiai užsakymų.
SELECT EXTRACT(DAY FROM order_date) AS day, COUNT(order_id) AS orders_count FROM orders
GROUP BY day
ORDER BY orders_count DESC;

--Kuris vairuotojas turi aukščiausią reitingą?
SELECT name, rating FROM drivers
WHERE rating IN (SELECT MAX(rating) FROM drivers);