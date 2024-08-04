public class PalindromePartitionMemoziation {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        int[][] memTable = new int[str.length()][str.length()];
        for(int i=0;i<memTable.length;i++) {
            for(int j=0;j<memTable[i].length;j++) {
                memTable[i][j] = -1;
            }
        }
        System.out.println("Min cuts needed for Palindrome Partitioning is "
                + minPalPartition(str, memTable, 0, str.length() - 1));
    }

    private static int minPalPartition(String str, int[][] memTable, int i, int j) {
        if(i >= j || isPalindrome(str, i ,j)) {
            return 0;
        }
        if(memTable[i][j] != -1) {
            return memTable[i][j];
        }
        int minCuts = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int cuts = 1 + minPalPartition(str, memTable, i, k) + minPalPartition(str, memTable, k+1, j);
            minCuts = Math.min(minCuts, cuts);
        }
        memTable[i][j] = minCuts;
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
