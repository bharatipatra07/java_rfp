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
     * UC11
     * Add employee using single transaction
     * Multiple tables are impacted
     */
    public void addEmployee(
            String name,
            String gender,
            String phoneNumber,
            String address,
            double salary,
            LocalDate startDate,
            List<String> departments
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
                    "(name, gender, phone_number, address, start_date) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement employeeStatement =
                    connection.prepareStatement(
                            employeeQuery,
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );

            employeeStatement.setString(1, name);
            employeeStatement.setString(2, gender);
            employeeStatement.setString(3, phoneNumber);
            employeeStatement.setString(4, address);

            employeeStatement.setDate(
                    5,
                    Date.valueOf(startDate)
            );

            int employeeRows =
                    employeeStatement.executeUpdate();

            /*
             * Fetch generated employee id
             */
            ResultSet generatedKeys =
                    employeeStatement.getGeneratedKeys();

            int employeeId = 0;

            if (generatedKeys.next()) {

                employeeId =
                        generatedKeys.getInt(1);
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
             * Insert department mapping
             */
            int departmentRows = 0;

            for (String departmentName : departments) {

                // Fetch department id
                String departmentQuery =
                        "SELECT department_id FROM department " +
                        "WHERE department_name = ?";

                PreparedStatement departmentStatement =
                        connection.prepareStatement(departmentQuery);

                departmentStatement.setString(
                        1,
                        departmentName
                );

                ResultSet departmentResult =
                        departmentStatement.executeQuery();

                int departmentId = 0;

                if (departmentResult.next()) {

                    departmentId =
                            departmentResult.getInt(
                                    "department_id"
                            );
                }

                /*
                 * Insert employee department mapping
                 */
                String mappingQuery =
                        "INSERT INTO employee_department " +
                        "(employee_id, department_id) " +
                        "VALUES (?, ?)";

                PreparedStatement mappingStatement =
                        connection.prepareStatement(mappingQuery);

                mappingStatement.setInt(1, employeeId);

                mappingStatement.setInt(2, departmentId);

                departmentRows +=
                        mappingStatement.executeUpdate();
            }

            /*
             * Commit transaction only if
             * all inserts successful
             */
            if (employeeRows > 0 &&
                    payrollRows > 0 &&
                    departmentRows == departments.size()) {

                // Commit transaction
                connection.commit();

                /*
                 * Update object only after
                 * successful transaction
                 */
                EmployeePayroll employee =
                        new EmployeePayroll(
                                employeeId,
                                name,
                                gender,
                                phoneNumber,
                                address,
                                salary,
                                startDate,
                                departments
                        );

                employeeList.add(employee);

                System.out.println(
                        "Employee payroll added successfully"
                );

            } else {

                // Rollback transaction
                connection.rollback();

                throw new PayrollException(
                        "Unable to add employee payroll"
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

    /*
     * Display employees
     */
    public void displayEmployees() {

        employeeList.forEach(System.out::println);
    }
}