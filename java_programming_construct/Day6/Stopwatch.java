
public class Stopwatch {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();

        long elapsed = end - start;
        System.out.println("Elapsed Time (ms) = " + elapsed);
    }
}