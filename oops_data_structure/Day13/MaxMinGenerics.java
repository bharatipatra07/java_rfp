public class MaxMinGenerics {

    public static Float testMaximum(Float a, Float b, Float c) {
        Float max = a;

        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(testMaximum(3.5f, 2.5f, 1.5f));
        System.out.println(testMaximum(1.5f, 3.5f, 2.5f));
        System.out.println(testMaximum(1.5f, 2.5f, 3.5f));
    }
}