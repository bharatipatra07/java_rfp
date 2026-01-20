public class BinarySearchFindPeak {
    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftOK  = (mid == 0) || arr[mid] > arr[mid - 1];
            boolean rightOK = (mid == arr.length - 1) || arr[mid] > arr[mid + 1];

            if (leftOK && rightOK) {
                return arr[mid]; // peak element
            }

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1; // move left
            } else {
                left = mid + 1;  // move right
            }
        }
        return -1; // should never happen for valid input
    }
    public static void main(String args[]){
        int[] arr = {1, 3, 20, 4, 1, 0};
        System.out.println(findPeak(arr));
    }
}