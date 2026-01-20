public class LinearSearchProblem1{
    public static int FindFirstNegativeNumber(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int[] arr={56,78,-1,90,-48};
        System.out.println(FindFirstNegativeNumber(arr));
    }
}