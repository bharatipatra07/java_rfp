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
    int totalWage;

    public Company(String name, int wagePerHour, int fullDayHour,
                   int partTimeHour, int maxDays, int maxHours) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.fullDayHour = fullDayHour;
        this.partTimeHour = partTimeHour;
        this.maxDays = maxDays;
        this.maxHours = maxHours;
        this.totalWage = 0;
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
            int days = 0, hours = 0, wage = 0;

            while (days < c.maxDays && hours < c.maxHours) {
                days++;
                int att = random.nextInt(3); // 0=Absent, 1=Full, 2=Part
                int worked = switch (att) {
                    case 1 -> c.fullDayHour;
                    case 2 -> c.partTimeHour;
                    default -> 0;
                };
                hours += worked;
                wage += worked * c.wagePerHour;
            }

            c.totalWage = wage;
        }
    }

    @Override
    public void printReports() {
        for (Company c : companies) {
            System.out.println("Company: " + c.name + " | Total Wage: " + c.totalWage);
        }
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        WageBuilder manager = new CompanyWageManager();

        manager.addCompany("TechSoft", 25, 8, 4, 20, 100);
        manager.addCompany("MegaCorp", 30, 9, 5, 22, 120);
        manager.addCompany("AlphaInc", 28, 8, 5, 25, 110); // added dynamically

        manager.computeWages();
        manager.printReports();
    }
}
