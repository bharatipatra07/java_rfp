public class BinarySearchTargetIndex {
    public static int binarySearchfindTarget(int[] arr,int target){
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target)return mid;
            else if(arr[mid]<target)left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {3, 4, -1, 1};
        // Binary Search result
        Arrays.sort(arr); // required for binary search
        int target1 = 4;
        int index = binarySearchfindTarget(arr4, target1);
        System.out.println("Index of " + target + ": " + index);
    }
}