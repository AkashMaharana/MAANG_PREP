import java.util.*;
public class NextSmallestElementToLeft {

     public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(11, 13, 21, 3);
        List<Integer> arr2 = Arrays.asList(4, 5, 2, 25);
        List<Integer> arr3 = Arrays.asList(13, 7, 6, 12);
        
        System.out.println(nextSmallestElement(arr));
        System.out.println(nextSmallestElement(arr2));
        System.out.println(nextSmallestElement(arr3));
    }
     
     private static List<Integer> nextSmallestElement(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i <= list.size() -1 ; i++) {
            while(!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            result.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(list.get(i));
        }
        return result;
     }
}
