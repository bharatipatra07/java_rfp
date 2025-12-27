package java_programming_construct.Day2;

import java.util.Scanner;

//Write a program Quadratic.java to find the roots of the equation a*x*x + b*x + c.
//Since the equation is x*x, hence there are 2 roots. The 2 roots of the equation can be
// found using a formula delta = b*b - 4*a*c
//Root 1 of x = (-b + sqrt(delta))/(2*a)
//Root 2 of x = (-b - sqrt(delta))/(2*a)
//        Take a, b, and c as input values to find the roots of x
public class Quadratic {
    public static void main(String args[]){
       System.out.println("Enter a,b,c");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int delta=b*b-(4*a*c);
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
