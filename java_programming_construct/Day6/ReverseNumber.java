package java_programming_construct.logical_program;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.print("Enter n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int reverse = 0;
        while (n != 0) {
            int rem = n % 10;
            reverse = reverse * 10 + rem;
            n = n / 10;
        }

        System.out.println("Reversed = " + reverse);
    }
}
