import java.util.*;
public class SmallestWindowInAStringContainingAllCharactesOfOtherString {

     public static void main(String[] args)
    {
        String str = "geeksforgeeks";
        String pat = "ork";
        System.out.print(smallestWindowSubstring(str, pat));
    }
     
     private static String smallestWindowSubstring(String s, String t) {
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> tempMap = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            patternMap.put(t.charAt(i), patternMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int required = patternMap.size();
        int formed = 0;
        int min_length = Integer.MAX_VALUE;
        String result_sub_string = "";
        while(right < s.length()) {
            char ch = s.charAt(right);
            tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
            if(patternMap.containsKey(ch) && patternMap.get(ch).equals(tempMap.get(ch))) {
                formed ++;
            }
            
            while(left <= right && formed == required) {
                if(right - left + 1 < min_length) {
                    min_length = right - left + 1;
                    result_sub_string = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                tempMap.put(leftChar, tempMap.get(leftChar) - 1);
                if(patternMap.containsKey(leftChar) && tempMap.get(leftChar) < patternMap.get(leftChar)) {
                    formed --;
                }
                left++;
            }
            right++;
        }
        return result_sub_string;
     }
}
