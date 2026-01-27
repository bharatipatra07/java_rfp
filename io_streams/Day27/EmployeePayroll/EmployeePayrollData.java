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

    // Convert file line to EmployeePayrollData object
    public static EmployeePayrollData fromFileString(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        double salary = Double.parseDouble(parts[2]);
        return new EmployeePayrollData(id, name, salary);
    }

    @Override
    public String toString() {
        return "EmployeePayroll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
