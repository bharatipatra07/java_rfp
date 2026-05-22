package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayrollServiceJDBC {

    // Database credentials
    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /*
     * UC3
     * Update employee salary using JDBC PreparedStatement
     */
    public void updateEmployeeSalary(String name, double salary)
            throws PayrollException {

        // SQL query for updating salary
        String query =
                "UPDATE employee_payroll SET salary = ? WHERE name = ?";

        try (
                // Establish DB connection
                Connection connection =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                // Create PreparedStatement
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            // Set values dynamically
            preparedStatement.setDouble(1, salary);
            preparedStatement.setString(2, name);

            // Execute update query
            int rowsAffected = preparedStatement.executeUpdate();

            // If no rows updated
            if (rowsAffected == 0) {
                throw new PayrollException("Employee not found");
            }

        } catch (SQLException e) {

            // Custom exception handling
            throw new PayrollException(
                    "Unable to update employee salary"
            );
        }
    }

    /*
     * Fetch employee payroll data from database
     */
    public EmployeePayroll getEmployeePayroll(String name)
            throws PayrollException {

        // SQL query
        String query =
                "SELECT * FROM employee_payroll WHERE name = ?";

        try (
                Connection connection =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            // Set employee name
            preparedStatement.setString(1, name);

            // Execute select query
            ResultSet resultSet =
                    preparedStatement.executeQuery();

            // Convert ResultSet -> Object
            if (resultSet.next()) {

                return new EmployeePayroll(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getDate("start_date").toLocalDate()
                );
            }

        } catch (SQLException e) {

            throw new PayrollException(
                    "Unable to fetch employee payroll data"
            );
        }

        return null;
    }
}