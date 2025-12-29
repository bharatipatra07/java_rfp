package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 10(Largest Among Three Numbers)
public class LargestOfThree {
    public static void main(String[] args) {
        System.out.println("Enter 3 Numbers: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int largest = a;
        if (b > largest) largest = b;
        if (c > largest) largest = c;

        System.out.println("Largest = " + largest);
    }
}
