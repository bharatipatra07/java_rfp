public class BubbleSortStudentMarks {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;

        for (int round= 1; round < n ; round++) {
            boolean swapped = false;

            for (int j = 0; j < n-round; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] marks = {78, 45, 89, 62, 55};
        System.out.println("Before Sorting:");
        printArray(marks);
        bubbleSort(marks);
        System.out.println("After Sorting:");
        printArray(marks);
    }
}