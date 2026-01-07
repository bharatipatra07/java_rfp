public class MaxMinGenerics{
    public static Integer testMaximum(Integer a, Integer b, Integer c) {
        Integer max = a;

        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        // TC 1.2 – Max at 2nd position
        System.out.println(testMaximum(10, 30, 20));
    }
}