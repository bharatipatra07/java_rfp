import java.util.Random;
class Company {
    final String name;
    final int wagePerHour;
    final int fullDayHour;
    final int partTimeHour;
    final int maxWorkingDays;
    final int maxWorkingHours;

    public Company(String name, int wagePerHour, int fullDayHour,
                   int partTimeHour, int maxWorkingDays, int maxWorkingHours) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.fullDayHour = fullDayHour;
        this.partTimeHour = partTimeHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }
}


class EmpWageBuilder {

    private final Company company;
    private int totalWage;
    private int totalWorkingDays;
    private int totalWorkingHours;

    private static final Random random = new Random();

    public EmpWageBuilder(Company company) {
        this.company = company;
    }

    public void computeEmployeeWage() {
        totalWorkingDays = 0;
        totalWorkingHours = 0;
        totalWage = 0;

        while (totalWorkingDays < company.maxWorkingDays &&
                totalWorkingHours < company.maxWorkingHours) {

            totalWorkingDays++;

            int attendance = random.nextInt(3); // 0=Absent, 1=Full, 2=Part
            int hoursWorked = switch (attendance) {
                case 1 -> company.fullDayHour;
                case 2 -> company.partTimeHour;
                default -> 0;
            };

            totalWorkingHours += hoursWorked;
            totalWage += hoursWorked * company.wagePerHour;
        }
    }

    public void printReport() {
        System.out.println(
                "Company: " + company.name +
                        " | Days: " + totalWorkingDays +
                        " | Hours: " + totalWorkingHours +
                        " | Total Wage: " + totalWage
        );
    }
}
public class EmployeeWage {
    public static void main(String[] args) {

        Company techSoft =
                new Company("TechSoft", 25, 8, 4, 20, 100);

        Company megaCorp =
                new Company("MegaCorp", 30, 9, 5, 22, 120);

        EmpWageBuilder techSoftWage = new EmpWageBuilder(techSoft);
        EmpWageBuilder megaCorpWage = new EmpWageBuilder(megaCorp);

        techSoftWage.computeEmployeeWage();
        megaCorpWage.computeEmployeeWage();

        techSoftWage.printReport();
        megaCorpWage.printReport();
    }
}
