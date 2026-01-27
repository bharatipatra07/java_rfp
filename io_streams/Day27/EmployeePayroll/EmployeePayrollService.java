package EmployeePayroll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePayrollService {

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        service.printEmployeePayrolls();
        service.countEntriesInFile();
    }

    // UC5: Print employee payrolls using File IO
    private void printEmployeePayrolls() {
        File file = new File(
                EmployeePayrollData.DIRECTORY,
                EmployeePayrollData.FILE_NAME
        );

        System.out.println("Employee Payrolls:");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                EmployeePayrollData employee =
                        EmployeePayrollData.fromFileString(line);
                System.out.println(employee);
            }
        } catch (IOException e) {
            System.out.println("Error reading payroll file: " + e.getMessage());
        }
    }

    // UC5: Count number of entries in file
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
            System.out.println("\nNumber of entries in file: " + count);
        } catch (IOException e) {
            System.out.println("Error counting entries: " + e.getMessage());
        }
    }
}
