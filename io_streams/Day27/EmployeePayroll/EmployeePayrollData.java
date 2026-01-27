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

    public static EmployeePayrollData fromFileString(String line) {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double salary = Double.parseDouble(data[2]);
        return new EmployeePayrollData(id, name, salary);
    }

    @Override
    public String toString() {
        return "EmployeePayroll{id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary + '}';
    }
}
