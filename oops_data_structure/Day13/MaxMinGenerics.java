class MaxMinLogic {

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
}
public class MaxMinGenerics<T extends Comparable<T>> {

    private T a;
    private T b;
    private T c;

    public MaxMinGenerics(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T testMaximum() {
        return MaxMinLogic.testMaximum(a, b, c);
    }

    public static void main(String[] args) {

        MaxMinGenerics<Integer> intTest =
                new MaxMinGenerics<>(10, 20, 30);
        System.out.println(intTest.testMaximum());

        MaxMinGenerics<Float> floatTest =
                new MaxMinGenerics<>(3.5f, 2.5f, 1.5f);
        System.out.println(floatTest.testMaximum());

        MaxMinGenerics<String> stringTest =
                new MaxMinGenerics<>("Apple", "Peach", "Banana");
        System.out.println(stringTest.testMaximum());
    }
}