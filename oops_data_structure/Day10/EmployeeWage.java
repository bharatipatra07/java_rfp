import java.util.Random;

class CompanyEmpWage {
    final String name;
    final int wagePerHour;
    final int fullDayHour;
    final int partTimeHour;
    final int maxWorkingDays;
    final int maxWorkingHours;

    int totalWage;

    public CompanyEmpWage(String name, int wagePerHour, int fullDayHour,
                          int partTimeHour, int maxWorkingDays, int maxWorkingHours) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.fullDayHour = fullDayHour;
        this.partTimeHour = partTimeHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.totalWage = 0;
    }
}

class EmpWageBuilder {

    private final CompanyEmpWage[] companies;
    private static final Random random = new Random();

    public EmpWageBuilder(CompanyEmpWage[] companies) {
        this.companies = companies;
    }

    public void computeEmployeeWages() {
        for (CompanyEmpWage company : companies) {
            int totalDays = 0;
            int totalHours = 0;
            int totalWage = 0;

            while (totalDays < company.maxWorkingDays &&
                    totalHours < company.maxWorkingHours) {
                totalDays++;
                int attendance = random.nextInt(3); // 0=Absent, 1=Full, 2=Part
                int hoursWorked = switch (attendance) {
                    case 1 -> company.fullDayHour;
                    case 2 -> company.partTimeHour;
                    default -> 0;
                };

                totalHours += hoursWorked;
                totalWage += hoursWorked * company.wagePerHour;
            }

            company.totalWage = totalWage;
            printReport(company, totalDays, totalHours);
        }
    }

    private void printReport(CompanyEmpWage company, int totalDays, int totalHours) {
        System.out.println(
                "Company: " + company.name +
                        " | Days: " + totalDays +
                        " | Hours: " + totalHours +
                        " | Total Wage: " + company.totalWage
        );
    }
}

public class EmployeeWage {
    public static void main(String[] args) {

        CompanyEmpWage techSoft = new CompanyEmpWage("TechSoft", 25, 8, 4, 20, 100);
        CompanyEmpWage megaCorp = new CompanyEmpWage("MegaCorp", 30, 9, 5, 22, 120);

        CompanyEmpWage[] companies = {techSoft, megaCorp};

        EmpWageBuilder wageBuilder = new EmpWageBuilder(companies);
        wageBuilder.computeEmployeeWages();
    }
}
