package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 4(Harmonic Number)
public class HarmonicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N:");
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println("N must not be zero");
            return;
        }

        double sum = 0.0;
        for (int i = 1; i <= N; i++) {
            sum += 1.0 / i;
        }

        System.out.println("Harmonic value = " + sum);
    }
}