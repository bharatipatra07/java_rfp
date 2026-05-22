package JDBC;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create service object
        PayrollService payrollService =
                new PayrollService();

        try {

            /*
             * Update Terisa salary to 3000000
             */
            payrollService.updateEmployeeSalary(
                    "Terisa",
                    3000000.00
            );

            /*
             * Fetch updated employee data
             */
            EmployeePayroll employee =
                    payrollService.getEmployeePayroll("Terisa");

            /*
             * Compare object salary with DB salary
             */
            if (employee.getSalary() == 3000000.00) {

                System.out.println(
                        "Salary updated and synced successfully"
                );

            } else {

                System.out.println(
                        "Salary sync failed"
                );
            }

            // Print employee details
            System.out.println(employee);

        } catch (PayrollException e) {

            // Handle custom exception
            System.out.println(e.getMessage());
        }
    }
}