package java_programming_construct.Day2;

import java.util.Scanner;

public class ForLoopReverseNumber {
    public static void main(){
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int reverseNum=0;
        for(int i=n;i>0;i/=10){
            int rem=i%10;
            reverseNum=reverseNum*10+rem;
        }
        System.out.println(reverseNum);
    }
}
