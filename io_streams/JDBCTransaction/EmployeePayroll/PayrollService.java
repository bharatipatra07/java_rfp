package EmployeePayroll;

iimport java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayrollService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    // Active employee list
    private List<EmployeePayroll> employeeList =
            new ArrayList<>();

    /*
     * UC12
     * Remove employee logically
     * Set is_active = false
     */
    public void removeEmployee(String name)
            throws PayrollException {

        // SQL query
        String query =
                "UPDATE employee_payroll " +
                "SET is_active = false " +
                "WHERE name = ?";

        try (
                // Create DB connection
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USER,
                                PASSWORD
                        );

                // Create PreparedStatement
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            // Set employee name
            preparedStatement.setString(1, name);

            // Execute update query
            int rowsAffected =
                    preparedStatement.executeUpdate();

            /*
             * Remove employee object
             * only if DB update successful
             */
            if (rowsAffected > 0) {

                employeeList.removeIf(
                        employee ->
                                employee.getName()
                                        .equals(name)
                );

                System.out.println(
                        "Employee removed successfully"
                );

            } else {

                throw new PayrollException(
                        "Employee not found"
                );
            }

        } catch (SQLException e) {

            throw new PayrollException(
                    "Unable to remove employee"
            );
        }
    }

    /*
     * Retrieve only active employees
     */
    public void getActiveEmployees()
            throws PayrollException {

        String query =
                "SELECT * FROM employee_payroll " +
                "WHERE is_active = true";

        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USER,
                                PASSWORD
                        );

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            var resultSet =
                    preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("id") + " " +
                        resultSet.getString("name")
                );
            }

        } catch (SQLException e) {

            throw new PayrollException(
                    "Unable to retrieve active employees"
            );
        }
    }
}