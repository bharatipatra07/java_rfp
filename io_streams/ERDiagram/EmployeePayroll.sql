SHOW DATABASES;
CREATE DATABASE payroll_service;
SHOW DATABASES;
-- Switch to payroll service database
USE payroll_service;

CREATE TABLE employee_payroll (
    EmployeeId INT AUTO_INCREMENT PRIMARY KEY,
    EmployeeName VARCHAR(100) NOT NULL,
    Phone VARCHAR(15),
    Address VARCHAR(200) DEFAULT 'Not Provided',
    Department VARCHAR(50) NOT NULL,
    StartDate DATE,
    BasicPay DECIMAL(10,2) NOT NULL DEFAULT 0,
    Deductions DECIMAL(10,2) NOT NULL DEFAULT 0,
    TaxablePay DECIMAL(10,2) NOT NULL DEFAULT 0,
    IncomeTax DECIMAL(10,2) NOT NULL DEFAULT 0,
    NetPay DECIMAL(10,2) NOT NULL DEFAULT 0
);

-- Insert Terissa as part of Sales department
INSERT INTO employee_payroll
(EmployeeName, Phone, Address, Department, StartDate,
 BasicPay, Deductions, TaxablePay, IncomeTax, NetPay)
VALUES
(
 'Terissa',
 '9876543210',
 'Mumbai',
 'Sales',
 '2023-01-10',
 50000,
 5000,
 45000,
 4500,
 40500
);

-- Insert Terissa again for Marketing department
-- This creates redundancy (same employee, new EmployeeId)
INSERT INTO employee_payroll
(EmployeeName, Phone, Address, Department, StartDate,
 BasicPay, Deductions, TaxablePay, IncomeTax, NetPay)
VALUES
(
 'Terissa',
 '9876543210',
 'Mumbai',
 'Marketing',
 '2023-01-10',
 50000,
 5000,
 45000,
 4500,
 40500
);

-- Fetch Terissa records
-- Shows two different EmployeeIds for the same person
SELECT
    EmployeeId,
    EmployeeName,
    Department,
    BasicPay
FROM employee_payroll
WHERE EmployeeName = 'Terissa';

-- Salary update
-- Multiple rows are updated due to redundancy
UPDATE employee_payroll
SET
    BasicPay = 60000,
    Deductions = 6000,
    TaxablePay = 54000,
    IncomeTax = 5400,
    NetPay = 48600
WHERE EmployeeName = 'Terissa';
