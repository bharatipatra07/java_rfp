package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 8(Number is Even or Odd)
public class EvenOdd{
    public static void main(String args[]){
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n%2==0)
            System.out.println(n+" is even");
        else
            System.out.println(n+" is odd");
    }
}
