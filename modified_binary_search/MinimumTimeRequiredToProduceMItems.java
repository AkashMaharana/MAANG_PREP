public class MinimumTimeRequiredToProduceMItems {
    public static void main(String[] args) {
        int[] arr= {1,2,3};
        int m=11;
        System.out.println("Minimum time required to produce m items : " + minimumTimeRequiredToProduceMItems(arr,m));
    }

    private static int minimumTimeRequiredToProduceMItems(int[] arr, int m) {
        int total_time = 0;
        for(int i=0;i<arr.length;i++) {
            total_time = total_time + arr[i];
        }
        int start = arr[arr.length-1];
        int end = total_time;
        int result = Integer.MAX_VALUE;
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(getNumberOfItems(arr,mid) >= m) {
                result = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }
        return result;
    }

    private static int getNumberOfItems(int[] arr, int mid) {
        int result = 0;
        for(int i=0;i<arr.length;i++) {
            result = result + mid/arr[i];
        }
        return result;
    }
}
