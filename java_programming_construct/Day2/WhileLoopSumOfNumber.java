//Write a Program for the sum of n natural numbers eg. Input N=5 output 1+2+3+4+5

package java_programming_construct.Day2;

import java.util.Scanner;

public class WhileLoopSumOfNumber {
    public static void main(String[] args){
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int sum=0;
        while(num>0){
          sum+=num;
          num--;
        }
        System.out.println(sum);
    }
}
