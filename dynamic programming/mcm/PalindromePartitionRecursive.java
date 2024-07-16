public class PalindromePartitionRecursive {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for Palindrome Partitioning is "
                        + minPalPartition(str, 0, str.length() - 1));
    }

    private static int minPalPartition(String str, int i, int j) {
        if(i >= j || isPalindrome(str, i ,j)) {
            return 0;
        }
        int minCuts = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int cuts = 1 + minPalPartition(str, i, k) + minPalPartition(str, k+1, j);
            minCuts = Math.min(minCuts, cuts);
        }
        return minCuts;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while(i<j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
