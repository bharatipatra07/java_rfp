package java_programming_construct.Day2;

import java.util.Scanner;

public class ForLoopPallindrome {
    public static void main(){
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int originalNumber=n;
        int reverseNum=0;
        for(int i=n;i>0;i/=10){
            int rem=i%10;
            reverseNum=reverseNum*10+rem;
        }
        if(originalNumber==reverseNum)
        System.out.println(originalNumber+" Number is pallindrome");
        else
        System.out.println(originalNumber+" Number is not pallindrome");
    }
}
