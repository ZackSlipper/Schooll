-- Active: 1729588129929@@127.0.0.1@3306@food_hunter

-- Uzd 1
SELECT orders.order_id, first_name, last_name, order_date, restaurant_name FROM orders
INNER JOIN customers ON orders.customer_id = customers.customer_id
INNER JOIN orders_items ON orders.order_id = orders_items.order_id
INNER JOIN food_items ON orders_items.item_id = food_items.item_id
INNER JOIN restaurants ON food_items.restaurant_id = restaurants.restaurant_id;

-- Uzd 2
SELECT restaurant_name,
COUNT(orders.order_id) AS orders_count, 
SUM(orders.total_price) AS total_income FROM orders
INNER JOIN orders_items ON orders.order_id = orders_items.order_id
INNER JOIN food_items ON orders_items.item_id = food_items.item_id
INNER JOIN restaurants ON food_items.restaurant_id = restaurants.restaurant_id
GROUP BY restaurant_name;

-- Uzd 3
SELECT first_name, last_name FROM customers
ORDER BY first_name, last_name ASC;

-- Uzd 4 (2022-08-01)
SELECT orders.order_id, restaurant_name, orders.total_price, order_date
FROM orders
INNER JOIN orders_items ON orders.order_id = orders_items.order_id
INNER JOIN food_items ON orders_items.item_id = food_items.item_id
INNER JOIN restaurants ON food_items.restaurant_id = restaurants.restaurant_id
WHERE orders.order_date > '2022-08-01';

-- Uzd 5 (most calories)
SELECT restaurant_name, MAX(calories) AS max_calories FROM food_items
INNER JOIN restaurants ON food_items.restaurant_id = restaurants.restaurant_id
GROUP BY food_items.restaurant_id;