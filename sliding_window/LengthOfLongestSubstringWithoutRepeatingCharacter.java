import java.util.*;
public class LengthOfLongestSubstringWithoutRepeatingCharacter{

     public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubsttr(str);
        System.out.println("The length of the longest non-repeating "
                + "character substring is " + len);
    }
     
     private static int longestUniqueSubsttr(String s) {
        int max_length = -1;
        int right = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right) , right);
            max_length = Math.max(max_length, right - left + 1);
            right++;
        }
        return max_length;
     }
}
