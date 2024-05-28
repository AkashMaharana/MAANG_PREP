import java.util.*;
public class NextGreaterElementToRight {

     public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(11, 13, 21, 3);
        List<Integer> arr2 = Arrays.asList(4, 5, 2, 25);
        List<Integer> arr3 = Arrays.asList(13, 7, 6, 12);
        
        System.out.println(nextLargerElement(arr));
        System.out.println(nextLargerElement(arr2));
        System.out.println(nextLargerElement(arr3));
    }
     
     private static List<Integer> nextLargerElement(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=list.size() - 1;i >= 0;i--) {
            while(!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            result.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(list.get(i));
        }
        Collections.reverse(result);
        return result;
     }
}
