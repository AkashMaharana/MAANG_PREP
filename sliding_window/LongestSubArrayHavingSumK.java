import java.util.*;
public class LongestSubArrayHavingSumK{

     public static void main(String []args){
        int[] arr = { 10, 5,0,0, 2, 7, 1,0, 9 };
        int n = arr.length;
        int k = 15;
        System.out.println("Length = "
                           + lenOfLongSubarr(arr, n, k));
     }
     
     private static int lenOfLongSubarr(int[] arr, int n, int k) {
         Map<Integer, Integer> map = new HashMap<>();
         int max_Length = 0;
         int prefix_sum = 0;
         for(int i=0;i<arr.length;i++) {
             prefix_sum = prefix_sum + arr[i];
             if(prefix_sum == k) {
                 max_Length = i + 1;
             } else if(map.containsKey(prefix_sum - k)) {
                 max_Length = Math.max(max_Length, i - map.get(prefix_sum - k));
             }
             if(!map.containsKey(prefix_sum)) {
                 map.put(prefix_sum, i);
             }
         }
         return max_Length;
     }
}
