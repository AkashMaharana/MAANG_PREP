import java.util.*;
class SortAStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(6);
        stack.add(2);
        stack.add(5);
        stack.add(4);
        stack.add(9);
        stack.add(1);
        stack.add(8);
        sort(stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("");
    }
    
    private static void sort(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);
        return;
    }
    
    private static void insert(Stack<Integer> stack, int temp) {
        if(stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }
        int last = stack.pop();
        insert(stack, temp);
        stack.push(last);
        return;
    }
}
