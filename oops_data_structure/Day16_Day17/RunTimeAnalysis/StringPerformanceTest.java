//3. Problem Statement: String Concatenation Performance
public class StringPerformanceTest {

    public static void main(String[] args) {

        final int N = 1_000_000; // Number of concatenations

        // Test String concatenation (O(N^2))
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // Immutable String creates a new object each time
        }
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Test StringBuilder concatenation (O(N))
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a"); // Mutable, fast
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Test StringBuffer concatenation (O(N))
        startTime = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbuf.append("a"); // Thread-safe, slightly slower than StringBuilder
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}