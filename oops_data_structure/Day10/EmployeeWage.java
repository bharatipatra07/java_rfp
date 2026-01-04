import java.util.Random;

class Employee {
    // Constants
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;

    // Instance variables
    private String name;
    private int totalWage;
    private int totalHours;
    private int totalDays;

    // Constructor
    public Employee(String name) {
        this.name = name;
        this.totalWage = 0;
        this.totalHours = 0;
        this.totalDays = 0;
    }

    // UC1 & UC2: Check Attendance and calculate daily wage
    public int calculateDailyWage() {
        Random random = new Random();
        int attendance = random.nextInt(3);
        int hoursWorked = 0;

        switch (attendance) { // UC3 &UC4
            case 0:
                System.out.println(name + " is Absent");
                hoursWorked = 0;
                break;
            case 1:
                System.out.println(name + " is Present (Full Time)");
                hoursWorked = FULL_DAY_HOUR;
                break;
            case 2:
                System.out.println(name + " is Present (Part Time)");
                hoursWorked = PART_TIME_HOUR;
                break;
            default:
                System.out.println("Invalid Attendance");
        }

        int dailyWage = hoursWorked * WAGE_PER_HOUR;
        System.out.println("Daily Wage: " + dailyWage);
        return dailyWage;
    }

    // UC5: Calculate wages for a month
    public void calculateMonthlyWage() {
        totalWage = 0;
        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            Random random = new Random();
            int attendance = random.nextInt(3); // 0 = Absent, 1 = Full Time, 2 = Part Time
            int hoursWorked = (attendance == 1) ? FULL_DAY_HOUR : (attendance == 2) ? PART_TIME_HOUR : 0;
            totalWage += hoursWorked * WAGE_PER_HOUR;
        }
        System.out.println("Monthly Wage for " + name + ": " + totalWage);
    }

    // UC6: Calculate wages till condition reached (max hours or max days)
    public void calculateWageTillCondition() {
        totalWage = 0;
        totalHours = 0;
        totalDays = 0;

        Random random = new Random();

        while (totalHours < MAX_WORKING_HOURS && totalDays < WORKING_DAYS_PER_MONTH) {
            totalDays++;
            int attendance = random.nextInt(3);
            int hoursWorked = (attendance == 1) ? FULL_DAY_HOUR : (attendance == 2) ? PART_TIME_HOUR : 0;
            totalHours += hoursWorked;
            totalWage += hoursWorked * WAGE_PER_HOUR;
        }

        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Wage till condition: " + totalWage);
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Kishor");

        System.out.println("----- UC1 & UC2 & UC3 & UC4: Daily Wage -----");
        emp1.calculateDailyWage();

        System.out.println("\n----- UC5: Monthly Wage -----");
        emp1.calculateMonthlyWage();

        System.out.println("\n----- UC6: Wage till condition -----");
        emp1.calculateWageTillCondition();
    }
}
