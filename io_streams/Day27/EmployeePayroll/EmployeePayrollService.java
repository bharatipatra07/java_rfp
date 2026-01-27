package EmployeePayroll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePayrollService {

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        service.showNumberOfEntries();
    }

    // UC6: Show number of entries in payroll file
    private void showNumberOfEntries() {
        File file = new File(
                EmployeePayrollData.DIRECTORY,
                EmployeePayrollData.FILE_NAME
        );

        int entryCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                entryCount++;
            }
            System.out.println("Number of employee entries: " + entryCount);
        } catch (IOException e) {
            System.out.println("Error reading payroll file: " + e.getMessage());
        }
    }
}
