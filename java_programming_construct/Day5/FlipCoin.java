package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 1(Flip Coin and print percentage of Heads and Tails)
public class FlipCoin {
    public static  void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of flips: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive integer");
            return;
        }
        int heads=0,tails=0;
        for(int i=0;i<n;i++){
            int rand=(int)Math.random();
            if(rand<0.5)
                tails++;
            else
                heads++;

        }
        System.out.println("Heads % ="+(heads*100)/n);
        System.out.println("Tails % ="+(tails*100)/n);

    }
}
