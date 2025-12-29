package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 7(Swap Two Numbers)
public class SwapNumbers {
    public static void main(String[] args) {
        System.out.println("Enter a,b:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a + ", b = " + b);
    }
}