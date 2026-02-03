SHOW DATABASES;
CREATE DATABASE payroll_service;
SHOW DATABASES;
-- Switch to payroll service database
USE payroll_service;

CREATE TABLE employee_payroll (
    EmployeeId INT IDENTITY(1,1) PRIMARY KEY,
    EmployeeName VARCHAR(100) NOT NULL,
    Phone VARCHAR(15),
    Address VARCHAR(200) DEFAULT 'Not Provided',
    Department VARCHAR(50) NOT NULL,
    StartDate DATE
);

ALTER TABLE employee_payroll
ADD 
    BasicPay DECIMAL(10,2) NOT NULL,
    Deductions DECIMAL(10,2) NOT NULL,
    TaxablePay DECIMAL(10,2) NOT NULL,
    IncomeTax DECIMAL(10,2) NOT NULL,
    NetPay DECIMAL(10,2) NOT NULL;

INSERT INTO employee_payroll
(EmployeeId, BasicPay, Deductions, TaxablePay, IncomeTax, NetPay)
VALUES
(1, 50000, 5000, 45000, 4500, 40500);

SELECT 
    EmployeeId,
    BasicPay,
    Deductions,
    TaxablePay,
    IncomeTax,
    NetPay
FROM employee_payroll;

