package java_programming_construct.Day2;

import java.util.Scanner;

public class OperatorMaxMinOfThreeNumber {
    public static void main(String[] args){
        System.out.println("Enter 3 numbers");
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();

        int result1 = num1+ num2 * num3;
        int result2 = num3 + num1 / num2;
        int result3 = num1 % num2 + num3;
        int result4 = num1 * num2 + num3;

        int max = Math.max(Math.max(result1, result2), Math.max(result3, result4));
        int min = Math.min(Math.min(result1, result2), Math.min(result1, result2));

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
            }
        }
