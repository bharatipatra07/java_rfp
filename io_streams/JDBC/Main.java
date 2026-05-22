package JDBC;

public class Main {

    public static void main(String[] args) {

        PayrollService payrollService =
                new PayrollService();

        try {

            // Display employee statistics
            payrollService.getEmployeeSalaryStatistics();

        } catch (PayrollException e) {

            System.out.println(e.getMessage());
        }
    }
}