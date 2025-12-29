package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 5(Factors)
public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        if (n > 1)
            System.out.print(n);
    }
}
