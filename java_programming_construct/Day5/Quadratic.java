package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;
//PROBLEM 3(two integer command-line arguments x
//and y and prints the Euclidean distance from the point (x, y) to the origin (0, 0). The
//formulae to calculate distance = sqrt(x*x + y*y).)
public class Quadratic {
    public static void main(String[] args) {
        System.out.println("Enter a,b and c");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Two real roots:");
            System.out.println("Root1 = " + root1);
            System.out.println("Root2 = " + root2);

        } else if (delta == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root:");
            System.out.println("Root = " + root);

        } else {
            System.out.println("No real roots");
        }
    }
}
