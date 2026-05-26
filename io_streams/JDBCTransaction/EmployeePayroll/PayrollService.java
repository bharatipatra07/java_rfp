package EmployeePayroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Store employee objects
    private List<EmployeePayroll> employeeList =
            new ArrayList<>();

    /*
     * UC7
     * Add new employee to payroll database
     */
    public void addEmployee(
            String name,
            double salary,
            String gender,
            LocalDate startDate
    ) throws PayrollException {

        // SQL insert query
        String query =
                "INSERT INTO employee_payroll " +
                "(name, salary, gender, start_date) " +
                "VALUES (?, ?, ?, ?)";

        try (
                // Create DB connection
                Connection connection =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                // Create PreparedStatement
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            // Set values
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, salary);
            preparedStatement.setString(3, gender);

            preparedStatement.setDate(
                    4,
                    Date.valueOf(startDate)
            );

            // Execute insert query
            int rowsAffected =
                    preparedStatement.executeUpdate();

            /*
             * Add object to list only if
             * DB operation successful
             */
            if (rowsAffected > 0) {

                EmployeePayroll employee =
                        new EmployeePayroll(
                                0,
                                name,
                                salary,
                                startDate
                        );

                employeeList.add(employee);

                System.out.println(
                        "Employee added successfully"
                );
            }

        } catch (SQLException e) {

            throw new PayrollException(
                    "Unable to add employee"
            );
        }
    }

    /*
     * Display all employees from list
     */
    public void displayEmployees() {

        employeeList.forEach(System.out::println);
    }
}