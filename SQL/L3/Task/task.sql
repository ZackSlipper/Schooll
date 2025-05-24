-- 1. Prekes zenklai surikiuoti abeceles tvarka
SELECT * FROM brands ORDER BY brand_name ASC;

-- 2. Automobiliai surikiuoti nuo brangiausio iki pigiausio
SELECT * FROM products ORDER BY list_price DESC;

-- 3. Car price average
SELECT avg(list_price) FROM products;

-- 4. 6th category name
SELECT category_name FROM categories WHERE category_ID = 6;

-- 5. Cars with price less than 10000eur
SELECT * FROM products WHERE list_price < 10000;

-- 6. First three cars
SELECT * FROM products LIMIT 3;

-- 7. Following 4 cars
SELECT * FROM products LIMIT 3, 4;

-- 8. Car brand where the third letter in its name is 'x'
SELECT brand_name FROM products INNER JOIN brands ON products.brand_id = brands.brand_ID WHERE brand_name LIKE '__x%';


-- 1. Full car info
SELECT category_name, brand_name, product_name, model_year, list_price FROM products INNER JOIN brands ON products.brand_id = brands.brand_ID INNER JOIN categories ON categories.category_ID = products.category_id;

-- 2. Most expensive car brand name
SELECT brand_name FROM products INNER JOIN brands ON products.brand_id = brands.brand_ID ORDER BY list_price DESC LIMIT 1;

-- 3. Average sports car price
SELECT avg(list_price) FROM products INNER JOIN categories ON categories.category_ID = products.category_id WHERE category_name = 'Coupe' OR category_name = 'visureigis';

-- 4. How many cars in each category
SELECT category_name, count(*) FROM products INNER JOIN categories ON products.category_id = categories.category_ID GROUP BY category_name;

-- 5. How many cars in each brand
SELECT brand_name, count(*) FROM products INNER JOIN brands ON products.brand_ID = brands.brand_ID GROUP BY brand_name;

-- 6. How many distinct cars
SELECT COUNT(DISTINCT product_name) FROM products;

-- 7. Find cars thats price is less than the average Ford car price
SELECT * FROM products WHERE list_price < (SELECT avg(list_price) FROM products INNER JOIN brands ON products.brand_id = brands.brand_ID WHERE brand_name = 'Ford');

-- 8. Most expensive brand
SELECT brand_name, list_price FROM products INNER JOIN brands ON brands.brand_ID = products.brand_id ORDER BY list_price DESC LIMIT 1;

-- 9. Most expensive car
SELECT * FROM products ORDER BY list_price DESC LIMIT 1;