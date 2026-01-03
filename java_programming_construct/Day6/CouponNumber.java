package java_programming_construct.logical_program;

import java.util.Scanner;

public class CouponNumber {

    static int getRandom(int n) {
        int r = (int) (Math.random()*n);
        return r;
    }

    static int collectCoupons(int n) {
        boolean[] collected = new boolean[n];
        int count = 0;
        int distinct = 0;

        while (distinct < n) {
            int value = getRandom(n);
            count++;

            if (!collected[value]) {
                collected[value] = true;
                distinct++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int total = collectCoupons(n);
        System.out.println("Total random numbers needed = " + total);
    }
}
