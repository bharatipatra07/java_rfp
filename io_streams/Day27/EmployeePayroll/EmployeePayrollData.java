package EmployeePayroll;

public class EmployeePayrollData {

    private final int id;
    private final String name;
    private final double salary;

    public static final String DIRECTORY = "employee-data";
    public static final String FILE_NAME = "employees.txt";

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toFileString() {
        return id + "," + name + "," + salary;
    }
}
