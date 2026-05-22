package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PayrollService {

    // Singleton object
    private static PayrollService payrollService;

    // Database credentials
    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Cached PreparedStatement
    private PreparedStatement employeePayrollDataStatement;

    /*
     * Private constructor
     * Prevent object creation from outside
     */
    private PayrollService() {

        try {

            // Create DB connection
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            /*
             * PreparedStatement cached at
             * Driver + DB + Program level
             */
            employeePayrollDataStatement =
                    connection.prepareStatement(
                            "SELECT * FROM employee_payroll WHERE name = ?"
                    );

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /*
     * Singleton method
     * Only one object created
     */
    public static PayrollService getInstance() {

        if (payrollService == null) {

            payrollService = new PayrollService();
        }

        return payrollService;
    }

    /*
     * Retrieve employee payroll data using cached PreparedStatement
     */
    public EmployeePayroll getEmployeePayrollData(String name)
            throws PayrollException {

        try {

            // Set dynamic value
            employeePayrollDataStatement.setString(1, name);

            // Reuse PreparedStatement
            ResultSet resultSet =
                    employeePayrollDataStatement.executeQuery();

            /*
             * Reuse ResultSet to populate object
             */
            if (resultSet.next()) {

                return getEmployeePayrollData(resultSet);
            }

        } catch (SQLException e) {

            throw new PayrollException(
                    "Unable to retrieve employee payroll data"
            );
        }

        return null;
    }

    /*
     * Convert ResultSet -> EmployeePayroll Object
     */
    private EmployeePayroll getEmployeePayrollData(ResultSet resultSet)
            throws SQLException {

        int id = resultSet.getInt("id");

        String name =
                resultSet.getString("name");

        double salary =
                resultSet.getDouble("salary");

        LocalDate startDate =
                resultSet.getDate("start_date").toLocalDate();

        return new EmployeePayroll(
                id,
                name,
                salary,
                startDate
        );
    }
}
