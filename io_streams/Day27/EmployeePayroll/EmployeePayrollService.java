package EmployeePayroll;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();

        List<EmployeePayrollData> employees = service.getTestEmployees();
        service.writeEmployeePayrollToFile(employees);
        service.countEntriesInFile();
    }

    private List<EmployeePayrollData> getTestEmployees() {
        List<EmployeePayrollData> employees = new ArrayList<>();
        employees.add(new EmployeePayrollData(1, "Amit", 50000));
        employees.add(new EmployeePayrollData(2, "Ravi", 60000));
        employees.add(new EmployeePayrollData(3, "Neha", 70000));
        return employees;
    }

    // Write employee payroll to file using File IO
    private void writeEmployeePayrollToFile(List<EmployeePayrollData> employees) {
        createDirectoryIfNotExists();

        File file = new File(
                EmployeePayrollData.DIRECTORY,
                EmployeePayrollData.FILE_NAME
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (EmployeePayrollData employee : employees) {
                writer.write(employee.toFileString());
                writer.newLine();
            }
            System.out.println("Employee payroll written to file");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Count number of entries in file
    private void countEntriesInFile() {
        File file = new File(
                EmployeePayrollData.DIRECTORY,
                EmployeePayrollData.FILE_NAME
        );

        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                count++;
            }
            System.out.println("Number of entries in file: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Create directory if not exists
    private void createDirectoryIfNotExists() {
        File directory = new File(EmployeePayrollData.DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
