class Employee {

    // -------- Class Variables --------
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_TIME = 1;
    static final int PART_TIME = 2;

    static final int FULL_TIME_HOURS = 8;
    static final int PART_TIME_HOURS = 4;

    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    // -------- Class Method --------
    static int computeEmployeeWage() {

        int totalWorkingHours = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;



        while (totalWorkingHours < MAX_WORKING_HOURS
                && totalWorkingDays < MAX_WORKING_DAYS) {

            totalWorkingDays++;

            int empType = (int)(Math.random()*3);
            int workingHours;

            switch (empType) {
                case FULL_TIME:
                    workingHours = FULL_TIME_HOURS;
                    break;

                case PART_TIME:
                    workingHours = PART_TIME_HOURS;
                    break;

                default:
                    workingHours = 0; // Absent
            }

            totalWorkingHours += workingHours;
            totalWage += workingHours * WAGE_PER_HOUR;
        }

        return totalWage;
    }

}
public class EmployeeWageComputation{
    public static void main(String[] args) {
        Employee emp=new Employee();
        int totalEmployeeWage = emp.computeEmployeeWage();
        System.out.println("Total Employee Wage: " + totalEmployeeWage);
    }
}