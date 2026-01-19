public class MaxMinGenerics {

    public static <T extends Comparable<T>> T testMaximum(T... values) {
        T max = values[0];

        for (T value : values) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        printMax(max);
        return max;
    }

    public static <T> void printMax(T max) {
        System.out.println("Maximum Value: " + max);
    }

    public static void main(String[] args) {

        testMaximum(10, 20, 30, 40);
        testMaximum("Apple", "Peach", "Banana");
    }
}
