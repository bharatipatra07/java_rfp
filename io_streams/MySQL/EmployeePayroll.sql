SHOW DATABASES;
CREATE DATABASE payroll_service;
SHOW DATABASES;
USE payroll_service;
select database();
-- Switch to payroll service database
USE payroll_service;

-- Create employee payroll table
CREATE TABLE employee_payroll (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    PRIMARY KEY (id)
);

-- Insert employee payroll data
INSERT INTO employee_payroll (name, salary, start_date)
VALUES
    ('Bill', 1000000.00, '2018-01-03'),
    ('Terisa', 2000000.00, '2019-11-13'),
    ('Charlie', 3000000.00, '2020-05-21');


-- Retrieve all employee payroll records
SELECT * FROM employee_payroll;


-- Retrieve salary of a particular employee (Bill)
SELECT salary
FROM employee_payroll
WHERE name = 'Bill';

-- Retrieve employees who joined between a date range
SELECT *
FROM employee_payroll
WHERE start BETWEEN CAST('2018-01-01' AS DATE)
              AND DATE(NOW());
