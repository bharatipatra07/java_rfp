package Day3;

public class EmployeeWage {
    public static void main(String[] args) {
        final int IS_PART_TIME = 1;
        final int IS_FULL_TIME = 2;
        final int EMP_RATE_PER_HOUR = 20;
        final int NUM_OF_WORKING_DAYS = 20;
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        for (int day=0;day< NUM_OF_WORKING_DAYS;day++) {
            // FIXED random logic
            int emp_check = (int) (Math.random() * 10) % 3;

            switch (emp_check) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;

                case IS_FULL_TIME:
                    empHrs = 8;
                    break;

                default:
                    empHrs = 0;
            }

            totalEmpHrs += empHrs;

            System.out.println("Day: " + totalWorkingDays + " Emp Hrs: " + empHrs
            );
        }

        int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
        System.out.println("Total Emp Wage: " + totalEmpWage);
    }
}
