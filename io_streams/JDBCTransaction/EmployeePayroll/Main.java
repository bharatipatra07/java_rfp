package EmployeePayroll;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        PayrollService payrollService =
                new PayrollService();

        try {

            // Add employee
            payrollService.addEmployee(
                    "Terisa",
                    3000000.00,
                    "F",
                    LocalDate.now()
            );

        } catch (PayrollException e) {

            System.out.println(e.getMessage());
        }
    }
}