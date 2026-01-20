public  class LinearSearchMissingPositive {
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 1];

        // mark valid positive numbers
        for (int num : arr) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }

        // find first unvisited positive
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return n + 1;
    }
    public static void main(String[] args){
        int[] arr = {3, 4, -1, 1};
        // Linear Search result
        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missing);
    }
}