package java_programming_construct.basic_core_java_functional_program;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

//PROBLEM 1(2D Array)
public class TwoDArrayInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        System.out.print("Enter rows: ");
        int m = sc.nextInt();
        System.out.print("Enter cols: ");
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(arr[i][j] + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}
