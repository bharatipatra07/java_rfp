package java_programming_construct.Day2;

import java.util.Scanner;

public class IfElseNumberUnit {
    public static void main(String[] args){
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1)System.out.println("Unit");
        else if(n==10)System.out.println("Ten");
        else if(n==100)System.out.println("Hundred");
        else if(n==1000)System.out.println("Thousand");
        else System.out.println("Invalid Input");
    }
}
