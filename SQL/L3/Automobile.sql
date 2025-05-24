CREATE DATABASE automobile;

USE automobile;

CREATE TABLE categories
(category_ID SMALLINT AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR(50) NOT NULL);

CREATE TABLE brands
(brand_ID SMALLINT AUTO_INCREMENT PRIMARY KEY,
brand_name VARCHAR(50) NOT NULL);

CREATE TABLE products 
(product_id INT(6) AUTO_INCREMENT PRIMARY KEY, 
product_name VARCHAR (50) NOT NULL, 
brand_id SMALLINT NOT NULL, 
category_id SMALLINT NOT NULL, 
model_year SMALLINT NOT NULL, 
list_price DECIMAL (10, 2) NOT NULL, 
FOREIGN KEY (category_id) REFERENCES categories (category_id), 
FOREIGN KEY (brand_id) REFERENCES brands (brand_id));

INSERT INTO `brands` (`brand_id`, `brand_name`) VALUES
(1, 'GMC'),
(2, 'Plymouth'),
(3, 'Mercedes-Benz'),
(4, 'Honda'),
(5, 'Chevrolet'),
(6, 'Ford'),
(7, 'Buick'),
(8, 'Bentley'),
(9, 'Lexus'),
(10, 'Dodge');

select * from brands;

INSERT INTO `categories` (`category_id`, `category_name`) VALUES
(1, 'Vienatūris'),
(2, 'Sedanai'),
(3, 'Kabrioletai'),
(4, 'Hečbekas'),
(5, 'Universalas'),
(6, 'visureigis'),
(7, 'Keleivinis mikroautobusas'),
(8, 'Coupe');

select * from categories;

INSERT INTO `products` (`product_id`, `product_name`, `brand_id`, `category_id`, `model_year`, `list_price`) VALUES
(1, 'Savanna', 1, 1, 1992, '9900.00'),
(2, 'Yukon', 1, 6, 2001, '18000.00'),
(3, 'Barracuda', 2, 3, 1970, '45100.00'),
(4, 'Vito', 3, 7, 2004, '5999.00'),
(5, 'Gl 63 Amg', 3, 6, 2014, '48000.00'),
(6, 'Civic VIII', 4, 2, 2009, '2828.00'),
(7, 'Lacetti', 5, 4, 2004, '899.00'),
(8, 'Mondeo', 6, 5, 2016, '13100.00'),
(9, 'Encore', 7, 6, 2013, '8700.00'),
(10, 'Azure', 8, 3, 2003, '99950.00'),
(11, 'Rx 450H', 9, 6, 2012, '17400.00'),
(12, 'Challenger', 10, 8, 2016, '36950.00');