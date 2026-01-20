//6. Problem Statement: Comparing Different Data Structures for Searching
import java.util.*;

public class DataStructureSearchTest {

    public static void main(String[] args) {

        int N = 1_000_000; // Dataset size
        int target = N - 1; // Element to search (last element for worst-case in Array)

        // Initialize Array
        int[] array = new int[N];
        for (int i = 0; i < N; i++) array[i] = i;

        // Initialize HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) hashSet.add(i);

        // Initialize TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) treeSet.add(i);

        // Array Search (Linear search, O(N))
        long startTime = System.nanoTime();
        boolean foundArray = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                foundArray = true;
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Array search found: " + foundArray + ", time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // HashSet Search (O(1) average)
        startTime = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("HashSet search found: " + foundHashSet + ", time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // TreeSet Search (O(log N))
        startTime = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("TreeSet search found: " + foundTreeSet + ", time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}


