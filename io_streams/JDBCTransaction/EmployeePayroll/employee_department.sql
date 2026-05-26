CREATE TABLE employee_department (

    employee_id INT,

    department_id INT,

    FOREIGN KEY (employee_id)
    REFERENCES employee_payroll(id)
    ON DELETE CASCADE,

    FOREIGN KEY (department_id)
    REFERENCES department(department_id)
    ON DELETE CASCADE
);