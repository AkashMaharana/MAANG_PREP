public class AllocateMinimumNumberOfPagesFronMBooksToNStudents {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println("Minimum number of pages a student will read : " + allocateMinimumPage(arr, k));
    }

    private static int allocateMinimumPage(int[] arr, int k) {
        int max_page = arr[0];
        int total_page = 0;
        for(int i=0;i<arr.length;i++) {
            max_page = Math.max(max_page, arr[i]);
            total_page = total_page + arr[i];
        }
        int start = arr[arr.length-1];
        int end = total_page;
        int result = Integer.MAX_VALUE;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(isPossible(arr,k,mid)) {
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int k, int mid) {
        int result = 1;
        int temp = 0;
        int i=0;
        while(i<=arr.length-1) {
            temp = temp+arr[i];
            if(temp>mid) {
                result++;
                temp = arr[i];
            }
            i++;
        }
        return result<=k;
    }

}
