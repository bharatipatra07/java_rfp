import java.util.Random;

class EmployeeWage {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;

    private static Random random = new Random();

    public static int computeDailyWage() {
        int attendance = random.nextInt(3);
        int hoursWorked = switch (attendance) {
            case 1 -> FULL_DAY_HOUR;
            case 2 -> PART_TIME_HOUR;
            default -> 0;
        };
        String status = (attendance == 0) ? "Absent" : (attendance == 1) ? "Full Time" : "Part Time";
        System.out.println("Employee is " + status + ", Hours Worked: " + hoursWorked);
        return hoursWorked * WAGE_PER_HOUR;
    }

    public static int computeMonthlyWage() {
        int totalWage = 0;
        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            totalWage += computeDailyWage();
        }
        return totalWage;
    }

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

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("----- Daily Wage -----");
        System.out.println("Daily Wage: " + EmployeeWage.computeDailyWage());

        System.out.println("----- Monthly Wage -----");
        System.out.println("Monthly Wage: " + EmployeeWage.computeMonthlyWage());

        System.out.println("----- Wage till Condition -----");
        System.out.println("Total Wage till Condition: " + EmployeeWage.computeWageTillCondition());
    }
}
