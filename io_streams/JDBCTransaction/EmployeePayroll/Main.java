package EmployeePayroll;
public class Main {

    public static void main(String[] args) {

        PayrollService payrollService =
                new PayrollService();

        try {

            /*
             * Remove employee from payroll
             */
            payrollService.removeEmployee(
                    "Terisa"
            );

            /*
             * Display active employees
             */
            payrollService.getActiveEmployees();

        } catch (PayrollException e) {

            System.out.println(e.getMessage());
        }
    }
}