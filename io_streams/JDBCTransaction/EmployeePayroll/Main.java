package EmployeePayroll;
import java.time.LocalDate;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

    	 PayrollService payrollService =
                 new PayrollService();

         try {

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

         } catch (PayrollException e) {

             System.out.println(e.getMessage());
         }
    }
}