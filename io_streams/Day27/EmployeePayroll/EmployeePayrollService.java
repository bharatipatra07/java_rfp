package Demo.EmployeePayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    private List<EmployeePayrollData> employeePayrollDataList;
    public EmployeePayrollService(){}
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList){
        this.employeePayrollDataList=employeePayrollList;
    }
    public static void main(String args[]){
        List<EmployeePayrollData> employeePayrollDataList=new ArrayList<>();
        EmployeePayrollService employeePayrollService=new EmployeePayrollService(employeePayrollDataList);
        Scanner consoleInputReader=new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }

    private void readEmployeePayrollData(Scanner sc){
        System.out.println("Enter employee id:");
        int id=sc.nextInt();
        System.out.println("Enter employee name");
        String name=sc.next();
        System.out.println("Enter employee salary");
        double salary=sc.nextDouble();
        employeePayrollDataList.add(new EmployeePayrollData(id,name,salary));
    }
    private void writeEmployeePayrollData(){
        System.out.println("\n Employee Payroll data to console \n"+employeePayrollDataList);
    }
}
