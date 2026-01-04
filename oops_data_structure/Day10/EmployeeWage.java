import java.util.ArrayList;
import java.util.Random;

interface WageBuilder {
    void addCompany(String name, int wagePerHour, int fullDayHour,
                    int partTimeHour, int maxDays, int maxHours);
    void computeWages();
    void printReports();
}

class Company {
    final String name;
    final int wagePerHour;
    final int fullDayHour;
    final int partTimeHour;
    final int maxDays;
    final int maxHours;
    private int totalWage;
    private final ArrayList<Integer> dailyWages;

    public Company(String name, int wagePerHour, int fullDayHour,
                   int partTimeHour, int maxDays, int maxHours) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.fullDayHour = fullDayHour;
        this.partTimeHour = partTimeHour;
        this.maxDays = maxDays;
        this.maxHours = maxHours;
        this.totalWage = 0;
        this.dailyWages = new ArrayList<>();
    }

    public void addDailyWage(int wage) {
        dailyWages.add(wage);
        totalWage += wage;
    }

    public int getTotalWage() {
        return totalWage;
    }

    public ArrayList<Integer> getDailyWages() {
        return dailyWages;
    }
}

class CompanyWageManager implements WageBuilder {

    private final ArrayList<Company> companies;
    private static final Random random = new Random();

    public CompanyWageManager() {
        companies = new ArrayList<>();
    }

    @Override
    public void addCompany(String name, int wagePerHour, int fullDayHour,
                           int partTimeHour, int maxDays, int maxHours) {
        companies.add(new Company(name, wagePerHour, fullDayHour, partTimeHour, maxDays, maxHours));
    }

    @Override
    public void computeWages() {
        for (Company c : companies) {
            int totalHours = 0;
            int day = 0;

            while (day < c.maxDays && totalHours < c.maxHours) {
                day++;
                int attendance = random.nextInt(3); // 0=Absent, 1=Full, 2=Part
                int hoursWorked = switch (attendance) {
                    case 1 -> c.fullDayHour;
                    case 2 -> c.partTimeHour;
                    default -> 0;
                };
                totalHours += hoursWorked;
                int dailyWage = hoursWorked * c.wagePerHour;
                c.addDailyWage(dailyWage);
            }
        }
    }

    @Override
    public void printReports() {
        for (Company c : companies) {
            System.out.println("Company: " + c.name);
            System.out.println("Daily Wages: " + c.getDailyWages());
            System.out.println("Total Wage: " + c.getTotalWage());
            System.out.println("---------------------------");
        }
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        WageBuilder manager = new CompanyWageManager();

        manager.addCompany("TechSoft", 25, 8, 4, 20, 100);
        manager.addCompany("MegaCorp", 30, 9, 5, 22, 120);

        manager.computeWages();
        manager.printReports();
    }
}
