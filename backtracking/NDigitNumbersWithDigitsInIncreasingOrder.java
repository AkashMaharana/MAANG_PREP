import java.util.*;
class NDigitNumbersWithDigitsInIncreasingOrder {
    public static void main(String[] args) {
        List<Integer> list = getAllIncreasingNumber(3);
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
    
    private static List<Integer> getAllIncreasingNumber(int n) {
        if(n==1) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<10;i++) {
                list.add(i);
            }
            return list;
        }
        List<Integer> list = new ArrayList<>();
        getNumbers(n, 0, list, 0);
        return list;
    }
    
    private static void getNumbers(int n, int prev, List<Integer> list, int num) {
        if(n == 0) {
            list.add(num);
            return;
        }
        for(int i = prev+1; i<=9; i++) {
            getNumbers(n-1, i, list, (num*10 + i));
        }
    }
}
