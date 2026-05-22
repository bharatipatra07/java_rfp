import java.time.LocalDate;

 class EmployeePayroll {
    private int id;
    private String name;
    private double salary;
    private LocalDate startDate; // New field

    // Old constructor (backward compatibility)
    public EmployeePayroll(int id, String name, double salary) {
        this(id, name, salary, null);
    }

    // New constructor
    public EmployeePayroll(int id, String name, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary + " | " + startDate;
    }
}
 
 //Custom Exception 
 class PayrollException extends Exception {
	    public PayrollException(String message) {
	        super(message);
	    }
	}
 import java.sql.*;
 import java.time.LocalDate;
 import java.util.ArrayList;
 import java.util.List;

 public class PayrollService {

     private static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
     private static final String USER = "root";
     private static final String PASSWORD = "root";

     // UC2 - Retrieve Employee Payroll Data
     public List<EmployeePayroll> readEmployeePayrollData() throws PayrollException {
         List<EmployeePayroll> employeeList = new ArrayList<>();

         String query = "SELECT id, name, salary, start_date FROM employee_payroll";

         try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
              Statement statement = connection.createStatement();
              ResultSet rs = statement.executeQuery(query)) {

             while (rs.next()) {
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 double salary = rs.getDouble("salary");
                 Date date = rs.getDate("start_date");

                 LocalDate startDate = (date != null) ? date.toLocalDate() : null;

                 // Populate object
                 EmployeePayroll emp = new EmployeePayroll(id, name, salary, startDate);
                 employeeList.add(emp);
             }

         } catch (SQLException e) {
             throw new PayrollException("Error retrieving employee payroll data: " + e.getMessage());
         }

         return employeeList;
     }
 }