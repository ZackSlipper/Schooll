CREATE DATABASE some_company;
USE some_company;

CREATE TABLE jobs (
	job_id INT PRIMARY KEY AUTO_INCREMENT,
	job_title VARCHAR(50) NOT NULL,
	min_salary INT NOT NULL,
	max_salary INT NOT NULL
);

CREATE TABLE locations (
	location_id INT PRIMARY KEY AUTO_INCREMENT,
	street_address VARCHAR(50) NOT NULL,
	postal_code VARCHAR(20) NOT NULL,
	city VARCHAR(50) NOT NULL
);

CREATE TABLE departments (
	department_id INT PRIMARY KEY AUTO_INCREMENT,
	department_name VARCHAR(50) NOT NULL,
	location_id INT NOT NULL,
	FOREIGN KEY (location_id) REFERENCES locations(location_id)
);

CREATE TABLE employees (
	employee_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	hire_date DATE NOT NULL,
	job_id INT NOT NULL,
	salary INT NOT NULL,
	department_id INT NOT NULL,
	FOREIGN KEY (job_id) REFERENCES jobs(job_id),
	FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

INSERT INTO jobs VALUES 
(0, "Programer", 1000, 10000),
(0, "HR", 1000, 6000),
(0, "Marketing manager", 500, 3000), 
(0, "Finance manager", 500, 3000), 
(0, "Shipping clerk", 200, 2000);

INSERT INTO locations VALUES
(0, 'Prè-Saint-Didier 123-5', 'G8Z 0N6', 'Jafarabad'),
(0, 'Sint-Lambrechts-Herk 69-789', '89933', 'Sibolga'),
(0, 'Saint-Brieuc 749-2', '23868-41697', 'San Antonio');

INSERT INTO departments VALUES
(0, 'Administration', 1),
(0, 'IT department', 2),
(0, 'Human Resource',3);


INSERT INTO employees VALUES
(0, 'Aquila', 'Freeman', '(021) 5113 0284', '2020-12-14', 2, 3569,  2),
(0, 'Berk', 'Griffith', '07254 988969', '2020-12-01', 3, 596, 3),
(0, 'Blaze', 'Sargent', '(0110) 806 3484', '2014-02-21', 1, 1000,  3),
(0, 'Hashim', 'Bull', '070 3430 3542', '2025-05-21', 2, 3113, 3),
(0, 'Bert', 'Edwards', '0845 46 47', '2005-11-21', 3, 5013, 3),
(0, 'Upton', 'Miller', '(01165) 89220', '2013-03-21', 2, 1823, 3),
(0, 'Arden', 'Oliver', '076 1887 4523', '2006-04-20', 2, 1280, 2),
(0, 'Dennis', 'Melton', '0939 945 2512', '2005-11-21', 1, 1000, 1),
(0, 'Ivor', 'Sutton', '(014754) 36009', '2010-04-20', 2, 3906, 3),
(0, 'Joel', 'Nguyen', '0332 442 1780', '2013-10-20', 3, 1185, 3),
(0, 'Ezekiel', 'Macdonald', '(01036) 956079', '2005-08-21', 1, 910,  2),
(0, 'Quamar', 'Oliver', '0845 46 47', '2004-08-21', 2, 3837, 2),
(0, 'Macaulay', 'Thomas', '07518 715188', '2013-02-21', 3, 2892,  3),
(0, 'Hasad', 'Fletcher', '(0114) 999 8484', '2022-09-20', 2, 2755, 2),
(0, 'Eaton', 'Santos', '0800 730678', '2011-09-21', 3, 4847, 2),
(0, 'Drake', 'Knox', '(016977) 3265', '2002-02-21', 1, 3968,  1),
(0, 'Ulysses', 'Gallegos', '055 4459 1679', '2011-05-20', 1, 2311,  3),
(0, 'Lester', 'Wolf', '(016977) 7398', '2022-01-20', 2, 2782, 3),
(0, 'Tyrone', 'Blankenship', '(01111) 824437', '2023-01-20', 3, 1487, 3),
(0, 'Slade', 'Horn', '076 5495 5246', '2010-02-20', 1, 1898, 2),
(0, 'Keegan', 'Terrell', '0800 696936', '2008-12-20', 3, 6437, 3),
(0, 'Talon', 'Moon', '(0141) 542 8813', '2026-01-20', 3, 6366, 2);


-- Gaukite visų darbuotojų vardus, pavardes ir jų pareigų pavadinimus.
SELECT first_name, last_name, job_title FROM employees
INNER JOIN jobs ON employees.job_id = jobs.job_id;

-- Suskaiciuokite kiek darbuotoju dirba kiekvienose pareigose. Nurodykite pareigų pavadinimus ir darbuotojų skaičių.
SELECT job_title, COUNT(*) AS employees_count FROM employees
INNER JOIN jobs ON employees.job_id = jobs.job_id
GROUP BY job_title;

-- Raskite darbuotojus, kurie buvo įdarbinti po 2015 metų. Nurodykite jų vardus, pavardes ir įdarbinimo datas.
SELECT first_name, last_name, hire_date FROM employees
WHERE hire_date >= '2016-01-01';

-- Suraskite, kiek kiekviename departamente yra darbuotojų. Nurodykite departamento ID ir darbuotojų skaičių.
SELECT department_name, COUNT(*) AS employees_count FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
GROUP BY department_name;

-- Surūšiuokite darbuotojų sąrašą pagal atlyginimą mažėjančia tvarka. Nurodykite darbuotojų vardus, pavardes ir atlyginimus.
SELECT first_name, last_name, salary FROM employees
ORDER BY salary DESC;

-- Raskite darbuotojus, kurių atlyginimas yra tarp 2000 ir 4000. Nurodykite jų vardus, pavardes ir atlyginimus.
SELECT first_name, last_name, salary FROM employees
WHERE salary BETWEEN 2000 AND 4000;

-- Raskite vidutinį darbuotojų atlyginimą kiekviename departamente. Nurodykite departamento ID ir vidutinį atlyginimą.
SELECT department_name, AVG(salary) AS avg_salary FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
GROUP BY department_name;

-- Gaukite darbuotojų vardus, pavardes ir jų departamento miestus.
SELECT first_name, last_name, city FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
INNER JOIN locations ON departments.location_id = locations.location_id;

-- Suraskite visų darbuotojų vardus, pavardes, darbo pavadinimus ir miestus, kuriuose jie dirba.
SELECT first_name, last_name, job_title, city FROM employees
INNER JOIN jobs ON employees.job_id = jobs.job_id
INNER JOIN departments ON employees.department_id = departments.department_id
INNER JOIN locations ON departments.location_id = locations.location_id;

-- Raskite departamentus, kuriuose vidutinis atlyginimas yra didesnis nei 3000. Nurodykite departamento ID ir vidutinį atlyginimą.
SELECT department_name, AVG(salary) AS avg_salary FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
GROUP BY department_name
HAVING avg_salary > 3000;

-- Suskaičiuokite, kiek darbuotojų dirba kiekviename darbe. Nurodykite darbo pavadinimą ir darbuotojų skaičių. ?????????
SELECT job_title, COUNT(*) AS employees_count FROM employees
INNER JOIN jobs ON employees.job_id = jobs.job_id
GROUP BY job_title;

-- Patikrinkite, ar yra darbuotojų, kurių duomenų lentelėje nėra nurodyta darbo ID (job_id). Jei tokių yra, parodykite jų vardus ir pavardes.
SELECT first_name, last_name FROM employees
WHERE job_id IS NULL;

-- Raskite darbuotojus, kurių telefono numeris prasideda „(011)“. Nurodykite jų vardus, pavardes ir telefono numerius.
SELECT first_name, last_name, phone_number FROM employees
WHERE phone_number LIKE '(011%';



-- Suraskite darbuotojus, dirbančius „IT department“ skyriuje ir uždirbančius daugiau nei 3000.
SELECT first_name, last_name, salary FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
WHERE department_name = 'IT department' AND salary > 3000;

-- Nurodykite 5 darbuotojus, kurių atlyginimas yra didžiausias. Parodykite jų vardus, pavardes ir atlyginimus.
SELECT first_name, last_name, salary FROM employees
ORDER BY salary DESC
LIMIT 5;

-- Raskite darbuotojus, kurie dirba „IT department“ arba uždirba mažiau nei 2000. Nurodykite jų vardus, pavardes ir atlyginimus.
SELECT first_name, last_name, salary FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
WHERE department_name = 'IT department' AND salary < 2000;
