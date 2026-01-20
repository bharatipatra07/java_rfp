public class ProductPriceSort {
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            // Partition the array
            int pi = partition(arr, low, high);

            // Recursively sort left part
            quickSort(arr, low, pi - 1);
            // Recursively sort right part
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // choosing last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and pivot
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return pivot index
    }

    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Example unsorted product prices
        double[] prices = {250.0, 99.99, 150.5, 300.0, 49.5, 200.0};

        System.out.println("Before Sorting:");
        printArray(prices);
        quickSort(prices, 0, prices.length - 1);

        System.out.println("After Sorting:");
        printArray(prices);
    }
}
