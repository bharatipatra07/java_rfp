CREATE TABLE employee_payroll (

    id INT PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(100) NOT NULL,

    gender CHAR(1),

    phone_number VARCHAR(15),

    address VARCHAR(255),

    start_date DATE
);
ALTER TABLE employee_payroll
ADD is_active BOOLEAN DEFAULT TRUE;