CREATE TABLE payroll_details (

    payroll_id INT PRIMARY KEY AUTO_INCREMENT,

    employee_id INT,

    basic_pay DOUBLE,

    deductions DOUBLE,

    taxable_pay DOUBLE,

    tax DOUBLE,

    net_pay DOUBLE,

    FOREIGN KEY (employee_id)
    REFERENCES employee_payroll(id)
    ON DELETE CASCADE
);