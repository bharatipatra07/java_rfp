//2. Problem Statement: Sorting Large Data Efficiently
public class SortingPerformanceTest {

    public static void main(String[] args) {

        // Dataset sizes to test
        int[] sizes = {1_000, 10_000, 100_000}; // Avoid 1,000,000 for BubbleSort (too slow)
        Random rand = new Random();

        for (int N : sizes) {
            System.out.println("\nDataset size: " + N);

            // Generate random dataset
            int[] originalData = new int[N];
            for (int i = 0; i < N; i++) {
                originalData[i] = rand.nextInt(N);
            }

            // Bubble Sort (O(N^2))
            if (N <= 10_000) { // Only run Bubble Sort for small datasets
                int[] bubbleData = Arrays.copyOf(originalData, N);
                long startTime = System.nanoTime();
                bubbleSort(bubbleData);
                long endTime = System.nanoTime();
                System.out.printf("Bubble Sort time: %.5f ms%n", (endTime - startTime) / 1_000_000.0);
            } else {
                System.out.println("Bubble Sort time: Unfeasible");
            }

            // Merge Sort (O(N log N))
            int[] mergeData = Arrays.copyOf(originalData, N);
            long startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long endTime = System.nanoTime();
            System.out.printf("Merge Sort time: %.5f ms%n", (endTime - startTime) / 1_000_000.0);

            // Quick Sort (O(N log N))
            int[] quickData = Arrays.copyOf(originalData, N);
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            endTime = System.nanoTime();
            System.out.printf("Quick Sort time: %.5f ms%n", (endTime - startTime) / 1_000_000.0);
        }
    }

    // Bubble Sort (O(N^2))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int round = 1; round < n ; round++) {
            swapped = false;
            for (int j = 0; j < n - round; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
