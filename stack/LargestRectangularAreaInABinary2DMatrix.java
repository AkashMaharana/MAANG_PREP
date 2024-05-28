import java.util.*;
class LargestRectangularAreaInABinary2DMatrix {
    public static void main(String[] args)
    {
        int R = 4;
        int C = 4;
        int A[][] = {
            { 0, 1, 1, 0 },
            { 1, 1, 1, 1 },
            { 1, 1, 1, 1 },
            { 1, 1, 0, 0 },
        };
        System.out.print("Area of maximum rectangle is "
                         + maxRectangle(R, C, A));
    }
    
    private static int maxRectangle(int R, int C, int A[][])
    {
        // Calculate area for first row and initialize it as
        // result
        int result = maxHist(R, C, A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

            // Update result if area with current row (as
            // last row of rectangle) is more
            result = Math.max(result, maxHist(R, C, A[i]));
        }

        return result;
    }
    
    private static int maxHist(int R, int C, int[] row) {
        return getMaxArea(row);
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
