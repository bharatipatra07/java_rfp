package EmployeePayroll;
iimport java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        PayrollService payrollService =
                new PayrollService();

        try {

            /*
             * Add employee payroll
             */
            payrollService.addEmployee(
                    "Terisa",
                    "F",
                    "9876543210",
                    "Chennai",
                    3000000.00,
                    LocalDate.now(),
                    Arrays.asList(
                            "HR",
                            "Sales"
                    )
            );

            // Display employee list
            payrollService.displayEmployees();

        } catch (PayrollException e) {

            System.out.println(e.getMessage());
        }
    }
}