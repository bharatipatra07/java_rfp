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
