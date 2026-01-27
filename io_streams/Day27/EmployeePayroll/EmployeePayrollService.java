package EmployeePayroll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        List<EmployeePayrollData> employees = service.readEmployeePayrollFile();

        System.out.println("Employee Payroll Data Loaded:");
        employees.forEach(System.out::println);
    }

    // UC7: Read payroll file using File IO
    private List<EmployeePayrollData> readEmployeePayrollFile() {
        List<EmployeePayrollData> employeeList = new ArrayList<>();

        File file = new File(
                EmployeePayrollData.DIRECTORY,
                EmployeePayrollData.FILE_NAME
        );

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                EmployeePayrollData employee =
                        EmployeePayrollData.fromFileString(line);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error reading payroll file: " + e.getMessage());
        }

        return employeeList;
    }
}
