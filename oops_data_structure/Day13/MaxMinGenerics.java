public class MaxMinGenerics {

    public static <T extends Comparable<T>> T testMaximum(T a, T b, T c) {
        T max = a;

        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(testMaximum(10, 20, 30));
        System.out.println(testMaximum(3.5f, 2.5f, 1.5f));
        System.out.println(testMaximum("Apple", "Peach", "Banana"));
    }
}