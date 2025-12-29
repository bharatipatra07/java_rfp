package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 6(Compute Quotient and Remainder)
public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int a = sc.nextInt();
        System.out.print("Enter divisor: ");
        int b = sc.nextInt();

        System.out.println("Quotient = " + (a / b));
        System.out.println("Remainder = " + (a % b));
    }
}
