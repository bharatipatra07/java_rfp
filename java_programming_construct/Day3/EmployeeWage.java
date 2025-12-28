package Day3;

public class EmployeeWage {
    public static void main(String args[]){
        final int IS_PRESENT=1;
        int empCheck=(int)(Math.floor(Math.random()*10))%2;
        if(empCheck==IS_PRESENT)
            System.out.print("Employee is present");
        else
            System.out.print("Employee is not present");
    }
}
