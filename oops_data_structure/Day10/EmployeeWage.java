import java.util.Random;

class Employee {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;

    private static Random random = new Random();

    // UC7: Class method to compute daily wage based on attendance
    public static int computeDailyWage() {
        int attendance = random.nextInt(3); // 0=Absent, 1=Full Time, 2=Part Time
        int hoursWorked = switch (attendance) {
            case 1 -> FULL_DAY_HOUR;
            case 2 -> PART_TIME_HOUR;
            default -> 0;
        };
        String status = (attendance == 0) ? "Absent" : (attendance == 1) ? "Full Time" : "Part Time";
        System.out.println("Employee is " + status + ", Hours Worked: " + hoursWorked);
        return hoursWorked * WAGE_PER_HOUR;
    }

    // UC7: Class method to compute monthly wage
    public static int computeMonthlyWage() {
        int totalWage = 0;
        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            totalWage += computeDailyWage();
        }
        return totalWage;
    }

    // UC7: Class method to compute wages till condition reached
    public static int computeWageTillCondition() {
        int totalWage = 0;
        int totalHours = 0;
        int totalDays = 0;

        while (totalHours < MAX_WORKING_HOURS && totalDays < WORKING_DAYS_PER_MONTH) {
            totalDays++;
            int dailyWage = computeDailyWage();
            totalHours += dailyWage / WAGE_PER_HOUR;
            totalWage += dailyWage;
        }

        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        return totalWage;
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("----- Daily Wage -----");
        System.out.println("Daily Wage: " + Employee.computeDailyWage());

        System.out.println("\n----- Monthly Wage -----");
        System.out.println("Monthly Wage: " + Employee.computeMonthlyWage());

        System.out.println("\n----- Wage till Condition -----");
        System.out.println("Total Wage till Condition: " + Employee.computeWageTillCondition());
    }
}
