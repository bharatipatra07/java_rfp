package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 2(Leap Year)
public class LeapYear {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        if (year < 1000 || year > 9999) {
            System.out.println("Enter a 4 digit year");
        } else if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
    }
}