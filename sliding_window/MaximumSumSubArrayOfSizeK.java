public class MaximumSumSubArrayOfSizeK {
   
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Maximum Sum : " + findMaxSum(arr, k));
    }

    private static int findMaxSum(int[] arr, int k) {
        int result = 0;
        int curr_sum;
        for(curr_sum = 0; curr_sum < k; ++curr_sum) {
            result += arr[curr_sum];
        }
        curr_sum = result;
        for(int i = k; i < arr.length; ++i) {
            curr_sum = curr_sum + arr[i] - arr[i - k];
            result = Math.max(result, curr_sum);
        }
        return result;
    }
}
