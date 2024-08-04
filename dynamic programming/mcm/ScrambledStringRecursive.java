import java.util.Arrays;

public class ScrambledStringRecursive {
    public static void main(String[] args) {
        String S1 = "great";
        String S2 = "greta";
        System.out.println("Is Scrambled : " + isScramble(S1, S2));
    }

    private static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if(s1.equals(s2)) {
            return true;
        }
        char[] temp1 = s1.toCharArray();
        char[] temp2 = s2.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        String temp11 = new String(temp1);
        String temp12 = new String(temp2);
        if(!temp11.equals(temp12)) {
            return false;
        }
        for(int i=1;i<s1.length();i++) {
            // Don't Swap
            if(isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, s1.length()), s2.substring(i, s1.length()))) {
                return true;
            }
            // Swap
            if(isScramble(s1.substring(0, s1.length() - i), s2.substring(i, s1.length())) &&
                    isScramble(s1.substring(s1.length() - i), s2.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
