
/*1. Iš lentelės orders išveskite tik šiuos stulpelius:
Užsakymo ID (order_id)
Pristatymo laiką (delivered_time)
Galutinę kainą (final_price)
Užsakymo įvertinimą (order_rating)*/

SELECT order_id, delivered_time, final_price, order_rating FROM orders;

/*2. Iš lentelės orders parodykite pirmuosius 10 000 įrašų, kuriuose yra šie stulpeliai:
Užsakymo ID (order_id)
Pristatymo laikas (delivered_time)
Galutinė kaina (final_price)
Užsakymo įvertinimas (order_rating)*/

SELECT order_id, delivered_time, final_price, order_rating FROM orders LIMIT 10000;

/*3. Praleiskite pirmuosius 10 000 įrašų lentelėje orders ir parodykite 20 000 įrašų po to. Išveskite šiuos stulpelius:
Užsakymo ID (order_id)
Pristatymo laiką (delivered_time)
Galutinę kainą (final_price)
Užsakymo įvertinimą (order_rating)*/

SELECT order_id, delivered_time, final_price, order_rating FROM orders LIMIT 10000, 20000;

--4. Parašykite užklausą, kuri rastų ankstyviausią užsakymo datą lentelėje orders.

SELECT MIN(order_date) FROM orders;

--5. Parašykite užklausą, kuri suskaičiuotų užsakymų skaičių lentelėje orders per birželio mėnesį (2022-06-01 iki 2022-06-30).

SELECT COUNT(order_id) FROM orders WHERE order_date LIKE '2022-06-%';
 
---6. Parašykite užklausą, kuri suskaičiuotų užsakymų skaičių lentelėje orders per rugpjūčio mėnesį (2022-08-01 iki 2022-08-31) naudojant BETWEEN.

SELECT COUNT(order_id) FROM orders WHERE order_date BETWEEN '2022-08-01' AND '2022-08-31';
 
--7. Parašykite užklausą, kuri lentelėje orders suskaičiuotų užsakymų skaičių kiekvieną mėnesį. Rezultate pridėkite alias (pvz., Order_Month ir OrderQuantity) naudojant AS.

SELECT COUNT(order_id) AS OrderQuantity, EXTRACT(MONTH FROM order_date) AS Order_Month FROM orders GROUP BY Order_Month;
SELECT COUNT(order_id) AS OrderQuantity, MONTHNAME(order_date) AS Order_Month FROM orders GROUP BY Order_Month;

/*8. Parašykite užklausą, kuri lentelėje orders apskaičiuotų:
Bendrą nuolaidų sumą (TotalDiscount).
Bendrą pajamų sumą (TotalRevenue) kiekvieną mėnesį.*/

SELECT ROUND(SUM(discount)) AS TotalDiscount, ROUND(SUM(final_price)) AS TotalRevenue, EXTRACT(MONTH FROM order_date) AS Order_Month FROM orders GROUP BY Order_Month;

/*9. Parašykite užklausą, kuri lentelėje orders apskaičiuotų:
Bendrą pajamų sumą (TotalRevenue).
Nuolaidų ir pajamų santykį (Discount_Sales_Ratio).
Bendrą nuolaidų sumą (TotalDiscount).
Užsakymų skaičių (OrderCount). Grupuokite pagal mėnesį ir rikiuokite pagal mėnesį.*/

SELECT 
	ROUND(SUM(final_price)) AS TotalRevenue,
	ROUND(SUM(discount) / SUM(final_price), 2) AS Discount_Sales_Ratio,
	ROUND(SUM(discount)) AS TotalDiscount,
	COUNT(order_id) AS OrderCount,
	EXTRACT(MONTH FROM order_date) AS Order_Month
FROM orders
GROUP BY Order_Month
ORDER BY Order_Month;

/*10. Parašykite užklausą, kuri apskaičiuotų kiekvieno maisto tipo užsakymų skaičių: */
SELECT
	food_type,
	COUNT(orders.order_id) AS OrderCount
FROM orders
INNER JOIN orders_items ON orders.order_id = orders_items.order_id
INNER JOIN food_items ON orders_items.item_id = food_items.item_id
GROUP BY food_type;