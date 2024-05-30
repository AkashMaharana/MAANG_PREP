import java.util.*;
class GenerateKthSymbolGrammar {
    public static void main(String[] args) {
        int n = 5;
        int k = 10;
        System.out.println(generateKthGrammar(n, k));
    }
    
    private static int generateKthGrammar(int n, int k) {
        if(n == 1 || k == 1) {
            return 0;
        }
        int mid = (int) (Math.pow(2, n - 1)) / 2;
        if(k <= mid) {
            return generateKthGrammar(n - 1, k);
        } else {
            return generateKthGrammar(n - 1, k - mid) == 1 ? 0 : 1;
        }
    }
}
