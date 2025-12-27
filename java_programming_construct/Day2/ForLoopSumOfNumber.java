package java_programming_construct.Day2;

import java.util.Scanner;

public class ForLoopSumOfNumber {
    public static void main(){
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
       for(int i=1;i<=n;i++){
         sum+=i;
       }
       System.out.println(sum);
    }
}
