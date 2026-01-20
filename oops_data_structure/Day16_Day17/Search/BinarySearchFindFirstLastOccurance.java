public class BinarySearchFindFirstLastOccurance {
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        return new int[]{first, last};
    }

    // Find first occurrence
    private static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // move left
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Find last occurrence
    private static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // move right
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {2, 4, 4, 4, 6, 7, 8};
        int targetElement = 4;

        int[] result = findFirstAndLast(arr, targetElement);
        System.out.println("First: " + result[0] + ", Last: " + result[1]);

    }
}