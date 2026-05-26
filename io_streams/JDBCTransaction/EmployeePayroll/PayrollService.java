package EmployeePayroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
     * UC8
     * Add employee and payroll details
     * using transaction management
     */
    public void addEmployeeWithPayrollDetails(
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
             * Disable auto commit
             * Transaction starts
             */
            connection.setAutoCommit(false);

            /*
             * Insert into employee_payroll
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
             * Get generated employee id
             */
            ResultSet generatedKeys =
                    employeeStatement.getGeneratedKeys();

            int employeeId = 0;

            if (generatedKeys.next()) {

                employeeId =
                        generatedKeys.getInt(1);
            }

            /*
             * Derived payroll calculations
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
             * Insert into payroll_details
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
             * Commit only if both inserts successful
             */
            if (employeeRows > 0 &&
                    payrollRows > 0) {

                connection.commit();

                /*
                 * Add employee object to list
                 */
                EmployeePayroll employee =
                        new EmployeePayroll(
                                employeeId,
                                name,
                                salary,
                                startDate
                        );

                employeeList.add(employee);

                System.out.println(
                        "Employee and payroll details added successfully"
                );

            } else {

                connection.rollback();

                throw new PayrollException(
                        "Unable to add employee payroll data"
                );
            }

        } catch (SQLException e) {

            try {

                if (connection != null) {

                    // Rollback transaction
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

    /*
     * Display employees
     */
    public void displayEmployees() {

        employeeList.forEach(System.out::println);
    }
}