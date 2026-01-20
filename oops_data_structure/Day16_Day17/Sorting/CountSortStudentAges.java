import java.util.Arrays;

public class CountSortStudentAges {
    public static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1; // range of ages
        int[] count = new int[range]; // count array
        int n = arr.length;
        int[] output = new int[n]; // output array

        // Count the occurrences of each age
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (iterate from end for stability)
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        return output;
    }
    public static void main(String[] args) {
        // Example unsorted student ages
        int[] ages = {12, 15, 10, 14, 12, 18, 16, 15, 11, 13, 12};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(ages));

        int[] sortedAges = countingSort(ages, 10, 18);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(sortedAges));
    }


}
