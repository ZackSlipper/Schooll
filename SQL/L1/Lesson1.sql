CREATE DATABASE kitm;
USE kitm;

CREATE TABLE mokiniai(
id SMALLINT auto_increment primary key,
name VARCHAR(55) NOT NULL,
email VARCHAR(55) NOT NULL,
reg_date TIMESTAMP);

SELECT * FROM mokiniai;

INSERT INTO mokiniai VALUES (0, "Gytis", "Gytis@gmail.com", NOW()), (0, "Egidijus", "Egidijus@gmail.com", NOW());
INSERT INTO mokiniai VALUES (0, "Andrius", "andrius@gmail.com", NOW());

SELECT name, email FROM mokiniai WHERE id=1;

UPDATE mokiniai
SET email = "mokinys@kitm.lt"
WHERE id = 1;

DELETE FROM mokiniai
WHERE id = 3;