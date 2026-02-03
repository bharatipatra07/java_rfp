SHOW DATABASES;
CREATE DATABASE payroll_service;
SHOW DATABASES;
-- Switch to payroll service database
USE payroll_service;

-- Department Table
CREATE TABLE Department (
    DeptId INT IDENTITY(1,1) PRIMARY KEY,
    DeptName VARCHAR(50) NOT NULL UNIQUE
);
-- Employee Table
CREATE TABLE Employee (
    EmpId INT IDENTITY(1,1) PRIMARY KEY,
    EmpName VARCHAR(100) NOT NULL,
    Phone VARCHAR(15),
    Address VARCHAR(200) DEFAULT 'Not Provided',
    DeptId INT NOT NULL,

    CONSTRAINT FK_Employee_Department 
    FOREIGN KEY (DeptId) REFERENCES Department(DeptId)
);


-- Payroll Table
CREATE TABLE Payroll (
    PayrollId INT IDENTITY(1,1) PRIMARY KEY,
    EmpId INT NOT NULL,
    BasicPay DECIMAL(10,2),
    Deductions DECIMAL(10,2),
    TaxablePay DECIMAL(10,2),
    NetPay DECIMAL(10,2),

    CONSTRAINT FK_Payroll_Employee
    FOREIGN KEY (EmpId) REFERENCES Employee(EmpId)
);
