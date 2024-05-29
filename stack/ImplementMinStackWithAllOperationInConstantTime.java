import java.util.*;
class ImplementMinStackWithAllOperationInConstantTime {
    public static void main(String[] args)
    {
        MinStack s = new MinStack();
        s.push(-1);
        s.push(10);
        s.push(-4);
        s.push(0);
        s.push(9);
        s.push(-27);
        s.push(19);
        System.out.println(s.getMin());
        s.pop();
        s.pop();
        System.out.println(s.getMin());
    }
}

class MinStack {
    Stack<Integer> stack = new Stack<>();
    int minElement = 0;
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            minElement = x;
        } else {
            if(x >= minElement) {
                stack.push(x);
            } else {
                stack.push(2*x - minElement);
                minElement = x;
            }
        }
    }
    
    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            if(stack.peek() >= minElement) {
                return stack.pop();
            } else {
                minElement = 2*minElement - stack.peek();
                return stack.pop();
            }
        }
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            if(stack.peek() > minElement) {
                return stack.peek();
            } else {
                return minElement;
            }
        }
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return minElement;
    }
}
