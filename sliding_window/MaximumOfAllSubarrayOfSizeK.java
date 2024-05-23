import java.util.*;
public class MaximumOfAllSubarrayOfSizeK{

     public static void main(String []args){
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        List<Integer> list = maximumOfAllSubarrayOfSizeK(arr, k);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
     }
     
     public static List<Integer> maximumOfAllSubarrayOfSizeK(int[] arr, int k) {
         List<Integer> ans = new ArrayList<>();
         PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> b.value - a.value);
         for (int i = 0; i < k; i++) {
            heap.offer(new Pair(arr[i], i));
        }
        ans.add(heap.peek().value);
        for (int i = k; i < arr.length; i++) {
            heap.offer(new Pair(arr[i], i));
            while (heap.peek().index <= i - k) {
                heap.poll();
            }
            ans.add(heap.peek().value);
        }
 
        return ans;
     }
     
     static class Pair {
        int value;
        int index;
 
        public Pair(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }
}
