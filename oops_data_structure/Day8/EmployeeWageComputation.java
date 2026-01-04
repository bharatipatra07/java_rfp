package Day8;


public class EmployeeWageComputation {
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 4;

    static final int WORKING_DAYS_PER_MONTH = 20;
    static final int MAX_WORKING_HOURS = 100;

    // ---------- UC1: Check Attendance ----------
    static int checkAttendance() {
        int attendance = (int)Math.random()*2;
        return attendance;
    }

    // ---------- UC2: Calculate Daily Wage ----------
    static int calculateDailyWage(int hours) {
        return hours * WAGE_PER_HOUR;
    }

    // ---------- UC3: Part Time using Switch Case ----------
    static int getWorkingHours() {
        int empType = (int)Math.random()*3;
        switch (empType) {
            case 1:
                return FULL_DAY_HOUR;
            case 2:
                return PART_TIME_HOUR;
            default:
                return 0;
        }
    }

    // ---------- UC4: Monthly Wage ----------
    static int calculateMonthlyWage() {
        int totalWage = 0;

        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            int hours = getWorkingHours();
            totalWage += calculateDailyWage(hours);
        }
        return totalWage;
    }

    // ---------- UC5 & UC6: Wage till Condition ----------
    static int calculateWageWithCondition() {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < MAX_WORKING_HOURS && totalDays < WORKING_DAYS_PER_MONTH) {
            totalDays++;
            int hours = getWorkingHours();
            totalHours += hours;
            totalWage += calculateDailyWage(hours);
        }
        return totalWage;
    }

    public static void main(String[] args) {

        // UC1
        if (checkAttendance() == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }

        // UC2
        int dailyWage = calculateDailyWage(FULL_DAY_HOUR);
        System.out.println("Daily Wage: " + dailyWage);

        // UC4
        int monthlyWage = calculateMonthlyWage();
        System.out.println("Monthly Wage: " + monthlyWage);

        // UC5 & UC6
        int conditionalWage = calculateWageWithCondition();
        System.out.println("Wage with Hour/Day Condition: " + conditionalWage);
    }
}

