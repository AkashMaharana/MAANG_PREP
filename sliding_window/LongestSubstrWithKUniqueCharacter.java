import java.util.*;
public class LongestSubstrWithKUniqueCharacter{

     public static void main(String[] args)
    {
        String s = "aaabacbebeeecbe";
        int k = 3;
        int ans = longestSubstrWithKUniqueCharacter(s, k);
        System.out.println(ans);
    }
     
     private static int longestSubstrWithKUniqueCharacter(String s, int k) {
         Map<Character, Integer> map = new HashMap<>();
         int i = -1;
         int j = -1;
         int max_length = -1;
         while(true) {
             boolean flag1 =false;
             boolean flag2 = false;
             while(i < s.length() - 1) {
                 flag1 = true;
                 i++;
                 char ch = s.charAt(i);
                 if(map.containsKey(ch)) {
                     map.put(ch, map.get(ch) + 1);
                 } else {
                     map.put(ch, 1);
                 }
                 if(map.size() < k) {
                     continue;
                 } else if (map.size() == k) {
                     int length = i-j;
                     max_length = Math.max(max_length, length);
                 } else {
                     break;
                 }
             }
             while(j < i) {
                 flag2 = true;
                 j++;
                 char ch = s.charAt(j);
                 if(map.get(ch) == 1) {
                     map.remove(ch);
                 } else {
                     map.put(ch, map.get(ch) - 1);
                 }
                 if (map.size() == k) {
                     int length = i-j;
                     max_length = Math.max(max_length, length);
                     break;
                 } else if (map.size() > k) {
                     continue;
                 }
             }
             if(flag1 == false && flag2 == false) {
                 break;
             }
         }
         return max_length;
     }
}
