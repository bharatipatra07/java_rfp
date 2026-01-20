public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int usi = 1; usi < n; usi++) {
            int key = arr[usi], curr;
            for (curr =usi - 1; curr >= 0 && arr[curr] > key; curr--) {
                arr[curr + 1] = arr[curr];
            }
            arr[curr + 1] = key;
        }
    }
    public static void printArray(int[] arr){
        for(int id:arr){
            System.out.print(id+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int[] employeeIDs = {102, 56, 78, 34, 89, 12, 67};

        System.out.println("Before Sorting:");
        printArray(employeeIDs);

        insertionSort(employeeIDs);

        System.out.println("After Sorting:");
        printArray(employeeIDs);
    }
}