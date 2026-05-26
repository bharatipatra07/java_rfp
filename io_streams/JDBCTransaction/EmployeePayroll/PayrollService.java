package EmployeePayroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PayrollService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /*
     * Add employee and payroll details
     * in single transaction
     */
    public void addEmployee(
            String name,
            double salary,
            String gender,
            LocalDate startDate
    ) throws PayrollException {

        Connection connection = null;

        try {

            // Create DB connection
            connection =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            /*
             * Start transaction
             */
            connection.setAutoCommit(false);

            /*
             * Insert employee data
             */
            String employeeQuery =
                    "INSERT INTO employee_payroll " +
                    "(name, salary, gender, start_date) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement employeeStatement =
                    connection.prepareStatement(
                            employeeQuery,
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );

            employeeStatement.setString(1, name);
            employeeStatement.setDouble(2, salary);
            employeeStatement.setString(3, gender);

            employeeStatement.setDate(
                    4,
                    Date.valueOf(startDate)
            );

            int employeeRows =
                    employeeStatement.executeUpdate();

            /*
             * Fetch generated employee id
             */
            ResultSet resultSet =
                    employeeStatement.getGeneratedKeys();

            int employeeId = 0;

            if (resultSet.next()) {

                employeeId =
                        resultSet.getInt(1);
            }

            /*
             * Payroll calculations
             */
            double deductions =
                    salary * 0.20;

            double taxablePay =
                    salary - deductions;

            double tax =
                    taxablePay * 0.10;

            double netPay =
                    salary - tax;

            /*
             * Insert payroll details
             */
            String payrollQuery =
                    "INSERT INTO payroll_details " +
                    "(employee_id, basic_pay, deductions, " +
                    "taxable_pay, tax, net_pay) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement payrollStatement =
                    connection.prepareStatement(payrollQuery);

            payrollStatement.setInt(1, employeeId);
            payrollStatement.setDouble(2, salary);
            payrollStatement.setDouble(3, deductions);
            payrollStatement.setDouble(4, taxablePay);
            payrollStatement.setDouble(5, tax);
            payrollStatement.setDouble(6, netPay);

            int payrollRows =
                    payrollStatement.executeUpdate();

            /*
             * Commit transaction only if
             * both inserts successful
             */
            if (employeeRows > 0 &&
                    payrollRows > 0) {

                connection.commit();

                System.out.println(
                        "Employee and payroll details added successfully"
                );

            } else {

                // Rollback transaction
                connection.rollback();

                throw new PayrollException(
                        "Unable to add employee payroll data"
                );
            }

        } catch (SQLException e) {

            try {

                if (connection != null) {

                    connection.rollback();
                }

            } catch (SQLException ex) {

                ex.printStackTrace();
            }

            throw new PayrollException(
                    "Database transaction failed"
            );

        } finally {

            try {

                if (connection != null) {

                    connection.close();
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}