public class MaximumSumSubArrayOfSizeK {
   
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Maximum Sum : " + maxSlidingWindow(arr, k));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.value - a.value);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++) {
            pq.add(new Pair(i, nums[i]));
        }
        list.add(pq.peek().value);
        for(int i=k;i<nums.length;i++) {
            pq.add(new Pair(i, nums[i]));
            while(pq.peek().index < (i-k+1)) {
                pq.poll();
            }
            list.add(pq.peek().value);
        }
        int[] output = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            output[i] = list.get(i);
        }
        return output;
    }
}

class Pair {
    int index;
    int value;
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
