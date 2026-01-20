//4. Problem Statement: Large File Reading Efficiency
import java.io.*;

public class FileReadPerformanceTest {

    public static void main(String[] args) {

        String filePath = "largefile.txt"; // Path to your large file (500MB)

        // Test FileReader (Character Stream)
        try {
            long startTime = System.nanoTime();

            FileReader fr = new FileReader(filePath);
            int c;
            while ((c = fr.read()) != -1) {
                // Do nothing, just read
            }
            fr.close();

            long endTime = System.nanoTime();
            System.out.println("FileReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test InputStreamReader (Byte Stream -> Character Stream)
        try {
            long startTime = System.nanoTime();

            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            int c;
            while ((c = isr.read()) != -1) {
                // Do nothing, just read
            }
            isr.close();
            fis.close();

            long endTime = System.nanoTime();
            System.out.println("InputStreamReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}