import java.util.*;
class StockSpanProblem {
    public static void main(String[] args)
    {
        int price[] = { 100,80,60,70,60,75,85 };
        List<Integer> list = calculateSpan(price);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    
    private static List<Integer> calculateSpan(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<=arr.length-1;i++) {
            int temp = arr[i];
            while(!stack.isEmpty() && stack.peek().price <= temp) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                list.add(i+1);
            } else {
                list.add(i-stack.peek().index);
            }
            stack.push(new Pair(temp, i));
        }
        return list;
     }
}

class Pair {
    int price;
    int index;
    public Pair(int price, int index) {
        this.price = price;
        this.index = index;
    }
}
