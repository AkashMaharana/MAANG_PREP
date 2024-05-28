import java.util.*;
class LargestRectangularAreaOfHistogram {
    public static void main(String[] args) 
    { 
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        System.out.println("Maximum area is "
                           + getMaxArea(hist)); 
    }
    
    private static int getMaxArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> left = getNearestSmallestLeft(arr);
        List<Integer> right = getNearestSmallestRight(arr);
        int max_area = -1;
        for(int i=0;i<arr.length;i++) {
            int area = (right.get(i) - left.get(i) - 1) * arr[i] ;
            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
    
    private static List<Integer> getNearestSmallestLeft (int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> left = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            int temp = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] >= temp) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left.add(-1);
            } else {
                left.add(stack.peek());
            }
            stack.push(i);
        }
        return left;
    }
    
    private static List<Integer> getNearestSmallestRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> right = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--) {
            int temp = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] >= temp) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right.add(arr.length);
            } else {
                right.add(stack.peek());
            }
            stack.push(i);
        }
        Collections.reverse(right);
        return right;
    }
}
