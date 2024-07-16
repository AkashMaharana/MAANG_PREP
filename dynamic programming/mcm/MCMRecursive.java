public class MCMRecursive {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        System.out.println("Minimum no of operations required : " + matrixMultiplication(arr, 1, arr.length-1));
    }

    private static int matrixMultiplication(int[] arr, int i, int j) {
        if(i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++) {
            int temp = matrixMultiplication(arr, i, k) +
                    matrixMultiplication(arr, k + 1, j) +
                    (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(min, temp);
        }
        return min;
    }
}
