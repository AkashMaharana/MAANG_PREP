import java.util.*;
class PrintAllPermutationOfAStringRecursion {
    public static void main(String[] args) {
        String input = "abc";
        boolean[] map = new boolean[input.length()];
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        printAllPermutation(input, map, list, ans);
        String temp = "";
        for(int i=0;i<ans.size();i++) {
            for(int j=0;j<ans.get(i).size();j++) {
                temp = temp + ans.get(i).get(j);
            }
            System.out.println(temp);
            temp = "";
        }
    }
    
    private static void printAllPermutation(String input, boolean[] map, List<String> list, List<List<String>> ans) {
        if(list.size() == input.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<input.length();i++) {
            if(!map[i]) {
                map[i] = true;
                list.add(input.charAt(i)+"");
                printAllPermutation(input, map, list, ans);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
    }
}
