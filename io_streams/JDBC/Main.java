package JDBC;

public class Main {

    public static void main(String[] args) {

        // Get singleton object
        PayrollService payrollService =
                PayrollService.getInstance();

        try {

            // Fetch employee payroll data
            EmployeePayroll employee =
                    payrollService.getEmployeePayrollData("Terisa");

            // Print employee data
            System.out.println(employee);

        } catch (PayrollException e) {

            System.out.println(e.getMessage());
        }
    }
}