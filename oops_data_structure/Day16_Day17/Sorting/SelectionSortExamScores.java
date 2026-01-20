public class SelectionSortExamScores {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int usi = 0; usi < n - 1; usi++) {
            // Find the minimum element in unsorted array
            int minIndex = usi;
            for (int j = usi+ 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[usi];
            arr[usi] = temp;
        }
    }
    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Example unsorted exam scores
        int[] scores = {85, 92, 76, 88, 69, 95, 80};

        System.out.println("Before Sorting:");
        printArray(scores);

        selectionSort(scores);

        System.out.println("After Sorting:");
        printArray(scores);
    }


}
