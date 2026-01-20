public class BookPriceSort {
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    public static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // size of first half
        int n2 = right - mid;    // size of second half

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        // Merge temp arrays back into original array
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr, if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr, if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Example unsorted book prices
        double[] bookPrices = {199.99, 49.5, 299.0, 159.75, 89.9, 120.0};

        System.out.println("Before Sorting:");
        printArray(bookPrices);

        // Sort using Merge Sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("After Sorting:");
        printArray(bookPrices);
    }


}
