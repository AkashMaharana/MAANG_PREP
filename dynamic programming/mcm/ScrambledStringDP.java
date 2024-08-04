import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScrambledStringDP {
    private static Map<String, Boolean> map = new HashMap<>();
    public static void main(String[] args) {
        String S1 = "coder";
        String S2 = "ocred";
        System.out.println("Is Scrambled : " + isScramble(S1, S2));
    }

    private static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        char[] temp1 = s1.toCharArray();
        char[] temp2 = s2.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        String temp11 = new String(temp1);
        String temp22 = new String(temp2);
        if(!temp11.equals(temp22)) {
            return false;
        }
        String key = s1 + " " + s2;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        boolean flag = false;
        for(int i=1;i<s1.length();i++) {
            // Don't Swap
            if(isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, s1.length()), s2.substring(i, s1.length()))) {
                flag = true;
                map.put(key, flag);
                return true;
            }
            // Swap
            if(isScramble(s1.substring(0, s1.length() - i), s2.substring(i, s1.length())) &&
                    isScramble(s1.substring(s1.length() - i), s2.substring(0, i))) {
                flag = true;
                map.put(key, flag);
                return true;
            }
        }
        map.put(key, flag);
        return false;
    }

}
