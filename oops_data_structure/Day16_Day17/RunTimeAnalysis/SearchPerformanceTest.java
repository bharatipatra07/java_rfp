//1. Problem Statement: Search a Target in a Large Dataset

public class SearchPerformanceTest {

    public static void main(String[] args) {

        // Test dataset sizes
        int[] sizes = {1_000, 10_000, 1_000_000};

        for (int N : sizes) {
            int[] data = new int[N];
            for (int i = 0; i < N; i++) data[i] = i;

            int target = N - 1; // Worst-case target for linear search

            System.out.println("\nDataset size: " + N);

            // Linear Search (O(N))
            long startTime = System.nanoTime();
            boolean foundLinear = linearSearch(data, target);
            long endTime = System.nanoTime();
            System.out.printf("Linear Search found: %b, time: %.5f ms%n",
                    foundLinear, (endTime - startTime) / 1_000_000.0);

            // Binary Search (O(log N))
            // Data must be sorted, already sorted here
            startTime = System.nanoTime();
            boolean foundBinary = binarySearch(data, target);
            endTime = System.nanoTime();
            System.out.printf("Binary Search found: %b, time: %.5f ms%n",
                    foundBinary, (endTime - startTime) / 1_000_000.0);
        }
    }

    // Linear search (O(N))
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // Binary search (O(log N))
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}