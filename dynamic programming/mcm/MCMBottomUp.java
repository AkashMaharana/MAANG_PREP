public class MCMBottomUp {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        System.out.println("Minimum no of operations required : " + matrixMultiplicationDP(arr));
    }

    private static int matrixMultiplicationDP(int[] arr) {
        int[][] memTable = new int[arr.length][arr.length];
        for(int i=1;i<memTable.length;i++) {
            memTable[i][i] = 0;
        }
        for(int i = arr.length - 1 ;i>=1;i--) {
            for(int j=i+1;j<arr.length;j++) {
                int min = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++) {
                    int temp = memTable[i][k] + memTable[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    min = Math.min(min, temp);
                }
                memTable[i][j] = min;
            }
        }
        return memTable[1][arr.length-1];
    }
}
