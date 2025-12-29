package Day3;

public class EmployeeWage {
    public static void main(String args[]){
        final int EMP_RATE_PER_HOUR=20;
        final int IS_PRESENT=1;
        int empHrs=0,empWage=0;
        int empCheck=(int)(Math.floor(Math.random()*10))%2;
        if(empCheck==IS_PRESENT)
            empHrs=8;
        empWage=empHrs*EMP_RATE_PER_HOUR;
        System.out.println(empWage);
    }
}
