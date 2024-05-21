public class MedianOfTwoSortedArrays{

     public static void main(String []args){
        int[] arr1 = {5, 8, 10, 20};
        int[] arr2 = {-12, -10, -6, -3, 4, 10 };
        System.out.println("Median : " + getMedian(arr1, arr2));
     }
     
     private static int getMedian(int[] arr1, int[] arr2) {
         if(arr1.length > arr2.length) {
             return getMedian(arr2, arr1);
         }
         int n1 = arr1.length;
         int n2 = arr2.length;
         int realMid = (n1 + n2 + 1) / 2;
         int start = 0;
         int end = arr1.length - 1;
         while(start<=end) {
             int mid = (end + start) / 2;
             int leftASize = mid;
             int leftBSize = realMid - mid;
             int leftA = leftASize > 0 ? arr1[leftASize - 1] : Integer.MIN_VALUE;
             int leftB = leftBSize > 0 ? arr2[leftBSize - 1] : Integer.MIN_VALUE;
             int rightA = leftASize < n1 ? arr1[leftASize] : Integer.MAX_VALUE;
             int rightB = leftBSize < n2 ? arr2[leftBSize] : Integer.MAX_VALUE;
             if(leftA <= rightB && leftB <= rightA) {
                 if((n1+n2) % 2 == 0) {
                     return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2;
                 }
                 return Math.max(leftA, leftB);
             } else if (leftA > rightB) {
                 end = mid -1;
             } else {
                 start = mid + 1;
             }
         }
         return 0;
     }
}
