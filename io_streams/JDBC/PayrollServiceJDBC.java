package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayrollService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /*
     * UC6
     * Find SUM, AVG, MIN, MAX and COUNT by gender
     */
    public void getEmployeeSalaryStatistics()
            throws PayrollException {

        // SQL query using aggregate functions
        String query =
                "SELECT gender, " +
                "SUM(salary) AS total_salary, " +
                "AVG(salary) AS average_salary, " +
                "MIN(salary) AS minimum_salary, " +
                "MAX(salary) AS maximum_salary, " +
                "COUNT(*) AS employee_count " +
                "FROM employee_payroll " +
                "GROUP BY gender";

        try (
                // Create DB connection
                Connection connection =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                // Create PreparedStatement
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            // Execute query
            ResultSet resultSet =
                    preparedStatement.executeQuery();

            // Print statistics
            while (resultSet.next()) {

                System.out.println(
                        "Gender : " +
                        resultSet.getString("gender")
                );

                System.out.println(
                        "SUM : " +
                        resultSet.getDouble("total_salary")
                );

                System.out.println(
                        "AVG : " +
                        resultSet.getDouble("average_salary")
                );

                System.out.println(
                        "MIN : " +
                        resultSet.getDouble("minimum_salary")
                );

                System.out.println(
                        "MAX : " +
                        resultSet.getDouble("maximum_salary")
                );

                System.out.println(
                        "COUNT : " +
                        resultSet.getInt("employee_count")
                );

                System.out.println("-------------------");
            }

        } catch (SQLException e) {

            throw new PayrollException(
                    "Unable to retrieve employee salary statistics"
            );
        }
    }
}