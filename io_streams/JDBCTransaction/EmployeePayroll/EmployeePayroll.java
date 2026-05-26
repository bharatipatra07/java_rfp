package javarfp;

import java.time.LocalDate;

public class EmployeePayroll {

    private int id;
    private String name;
    private double salary;
    private LocalDate startDate;

    // Constructor
    public EmployeePayroll(
            int id,
            String name,
            double salary,
            LocalDate startDate
    ) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    @Override
    public String toString() {

        return id + " " +
                name + " " +
                salary + " " +
                startDate;
    }
}
