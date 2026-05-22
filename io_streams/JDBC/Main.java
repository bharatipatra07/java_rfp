package javarfp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PayrollService service = new PayrollService();

        try {
            List<EmployeePayroll> employees = service.readEmployeePayrollData();

            employees.forEach(System.out::println);

        } catch (PayrollException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }
}
