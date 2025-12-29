package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 2(Sum of three Integer adds to ZERO)
public class ThreeSumZero {
    public static void main(String[] args) {
        System.out.println("Enter N:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        count++;
                    }
                }
            }
        }

        System.out.println("Total Triplets = " + count);
    }
}
