package EmployeePayroll;

import java.time.LocalDate;
import java.util.List;

public class EmployeePayroll {

    private int id;
    private String name;
    private String gender;
    private String phoneNumber;
    private String address;
    private double salary;
    private LocalDate startDate;

    // Multiple departments
    private List<String> departments;
    public EmployeePayroll(
            int id,
            String name,
            String gender,
            String phoneNumber,
            String address,
            double salary,
            LocalDate startDate,
            List<String> departments
    ) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.startDate = startDate;
        this.departments = departments;
    }
    @Override
    public String toString() {

        return id + " " +
                name + " " +
                gender + " " +
                salary + " " +
                startDate + " " +
                departments;
    }
}