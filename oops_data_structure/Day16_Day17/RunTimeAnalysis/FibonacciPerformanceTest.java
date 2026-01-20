//5. Problem Statement: Recursive vs Iterative Fibonacci Computation
public class FibonacciPerformanceTest {

    public static void main(String[] args) {

        int n = 40; // Fibonacci number to compute (adjust as needed)

        // Recursive Fibonacci
        long startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci of " + n + " = " + recursiveResult);
        System.out.println("Recursive time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Iterative Fibonacci
        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci of " + n + " = " + iterativeResult);
        System.out.println("Iterative time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    // Recursive approach (O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative approach (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}