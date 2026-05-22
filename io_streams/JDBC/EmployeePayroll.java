package JDBC;

import java.time.LocalDate;

public class EmployeePayroll {
    private int id;
    private String name;
    private double salary;
    private LocalDate startDate; // New field

    // constructor
    public EmployeePayroll(int id, String name, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary + " | " + startDate;
    }
}
