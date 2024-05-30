import java.util.*;
class SortAnArrayUsingRecursion {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(1);
        list.add(8);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        sort(list);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    
    private static void sort(List<Integer> list) {
        if(list.size() == 1) {
            return;
        }
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        sort(list);
        insert(list, temp);
        return;
    }
    
    private static void insert(List<Integer> list, int temp) {
        if(list.size() == 0 || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }
        int last = list.get(list.size() -1);
        list.remove(list.size()-1);
        insert(list, temp);
        list.add(last);
        return;
    }
}
