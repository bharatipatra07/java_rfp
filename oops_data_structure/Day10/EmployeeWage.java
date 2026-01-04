import java.util.Random;

class Company {
    String name;
    int wagePerHour;
    int fullDayHour;
    int partTimeHour;
    int workingDays;
    int maxHours;

    public Company(String name, int wagePerHour, int fullDayHour, int partTimeHour, int workingDays, int maxHours) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.fullDayHour = fullDayHour;
        this.partTimeHour = partTimeHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
    }
}

// Calculator class with class methods
class EmployeeWageCalculator {
    private static Random random = new Random();

    // Compute daily wage based on hours
    public static int computeDailyWage(int hoursWorked, int wagePerHour) {
        return hoursWorked * wagePerHour;
    }

    // Compute total monthly wage for a company
    public static int computeMonthlyWage(Company company) {
        int totalWage = 0;
        System.out.println("\nCompany: " + company.name);
        for (int day = 1; day <= company.workingDays; day++) {
            int attendance = random.nextInt(3); // 0=Absent, 1=Full Time, 2=Part Time
            int hoursWorked = switch (attendance) {
                case 1 -> company.fullDayHour;
                case 2 -> company.partTimeHour;
                default -> 0;
            };
            int dailyWage = computeDailyWage(hoursWorked, company.wagePerHour);
            totalWage += dailyWage;

            String status = (attendance == 0) ? "Absent" : (attendance == 1) ? "Full Time" : "Part Time";
            System.out.println("Day " + day + ": " + status + ", Hours: " + hoursWorked + ", Daily Wage: " + dailyWage);
        }
        System.out.println("Total Monthly Wage for " + company.name + ": " + totalWage);
        return totalWage;
    }

    // Compute wage till condition (max hours or days)
    public static int computeWageTillCondition(Company company) {
        int totalWage = 0;
        int totalHours = 0;
        int totalDays = 0;

        System.out.println("\nCompany: " + company.name);

        while (totalDays < company.workingDays && totalHours < company.maxHours) {
            totalDays++;
            int attendance = random.nextInt(3);
            int hoursWorked = switch (attendance) {
                case 1 -> company.fullDayHour;
                case 2 -> company.partTimeHour;
                default -> 0;
            };
            totalHours += hoursWorked;
            int dailyWage = computeDailyWage(hoursWorked, company.wagePerHour);
            totalWage += dailyWage;

            String status = (attendance == 0) ? "Absent" : (attendance == 1) ? "Full Time" : "Part Time";
            System.out.println("Day " + totalDays + ": " + status + ", Hours: " + hoursWorked + ", Daily Wage: " + dailyWage);
        }

        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Wage till Condition for " + company.name + ": " + totalWage);
        return totalWage;
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        // Create company objects
        Company techSoft = new Company("TechSoft", 25, 8, 4, 22, 100);
        Company megaCorp = new Company("MegaCorp", 30, 9, 5, 20, 120);

        // Compute wages for multiple companies
        EmployeeWageCalculator.computeMonthlyWage(techSoft);
        EmployeeWageCalculator.computeMonthlyWage(megaCorp);

        EmployeeWageCalculator.computeWageTillCondition(techSoft);
        EmployeeWageCalculator.computeWageTillCondition(megaCorp);
    }
}
