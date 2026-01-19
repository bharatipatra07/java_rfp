
import java.util.Arrays;

public class MaxMinGenerics {

    public static <T extends Comparable<T>> T testMaximum(T... values) {
        Arrays.sort(values);
        return values[values.length - 1];
    }

    public static void main(String[] args) {

        System.out.println(testMaximum(10, 40, 20, 30));
        System.out.println(testMaximum("Apple", "Banana", "Peach", "Orange"));
    }
}