import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class FindAllAnagramsOfAStringInAGivenString{

     public static void main(String []args){
        String s = "cbaebabacd";
        String t = "abc";
        List<Integer> list = countAnagrams(s,t);
        System.out.println("Number of anagrams : " + list.size());
     }
     
     private static List<Integer> countAnagrams(String s , String t) {
         List<Integer> list = new ArrayList<>();
         Map<Character, Integer> map = new HashMap<>();
         for(int i=0;i<t.length();i++){
             if(map.containsKey(t.charAt(i))) {
                 map.put(t.charAt(i), map.get(t.charAt(i))+1);
             } else {
                 map.put(t.charAt(i) , 1);
             }
         }
         int i=0;
         int j=0;
         int k = t.length();
         int count = map.size();
         while(j<s.length()) {
             char ch = s.charAt(j);
             if(map.containsKey(ch)) {
                 map.put(ch, map.get(ch)-1);
                 if(map.get(ch) == 0) {
                     count--;
                 }
             }
             if(j-i+1<k) {
                 j++;
             } else if(j-i+1==k) {
                 if(count==0) {
                     list.add(i);
                 }
                 char ch1 = s.charAt(i);
                 if(map.containsKey(ch1)) {
                     map.put(ch1, map.get(ch1)+1);
                     if(map.get(ch1) == 1) {
                         count++;
                     }
                 }
                 i++;
                 j++;
             }
         }
         return list;
     }
     
}
