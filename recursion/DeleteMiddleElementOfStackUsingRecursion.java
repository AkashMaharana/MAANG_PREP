import java.util.*;
class DeleteMiddleElementOfStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(6);
        stack.add(2);
        stack.add(5);
        stack.add(4);
        stack.add(9);
        stack.add(1);
        stack.add(8);
        int mid = (stack.size() / 2 ) + 1;
        deleteMiddleElement(stack, mid);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("");
    }
    
    private static void deleteMiddleElement(Stack<Integer> stack, int k) {
        if(stack.isEmpty()) {
            return;
        }
        solve(stack, k);
        return;
    }
    
    private static void solve(Stack<Integer> stack, int k) {
        if(k==1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        solve(stack, k-1);
        stack.push(temp);
        return;
    }
}
