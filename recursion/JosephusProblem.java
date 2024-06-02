import java.util.*;
class JosephusProblem {
    public static void main(String[] args) {
        int soilders = 14;
        int k = 2;
        k--;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=soilders;i++) {
            list.add(i);
        }
        int index = 0;
        findThewinner(list, k, index);
    }
    
    private static void findThewinner(List<Integer> list, int k, int index) {
        if(list.size() == 1) {
            System.out.println(list.get(index));
            return;
        }
        index = (index + k) % list.size();
        list.remove(index);
        findThewinner(list, k, index);
        return;
    }
}
