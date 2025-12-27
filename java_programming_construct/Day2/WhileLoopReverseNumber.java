// Write a Program to reverse the integer number eg. Input n=231 reverse is 132


package java_programming_construct.Day2;

import java.util.Scanner;

public class WhileLoopReverseNumber {
    public static void main(){
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int reverseNum=0;
        while(num>0){
          int rem=num%10;
          reverseNum=reverseNum*10+rem;
          num/=10;
        }
        System.out.println(reverseNum);
    }
}
