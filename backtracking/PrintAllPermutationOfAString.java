import java.util.*;
class PrintAllPermutationOfAString {
    public static void main(String[] args) {
        String input = "abc";
        printAllPermutation(input, 0, input.length()-1);
    }
    
    private static void printAllPermutation(String input, int l, int r) {
        if(l==r) {
            System.out.println(input);
            return;
        }
        for(int i=l;i<=r;i++) {
            input = swap(input, l, i);
            printAllPermutation(input, l+1, r);
            input = swap(input, l, i);
        }
        return;
    }
    
    private static String swap(String input, int l, int r) {
        char[] chArray = input.toCharArray();
        char temp = chArray[l];
        chArray[l] = chArray[r];
        chArray[r] = temp;
        return String.valueOf(chArray);
    }
}
