public class EvaluateBooleanExpressionToTrue {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        String exp = "F|T^F";
        int ways = evaluateExpWays(exp);
        System.out.println("The total number of ways: " + ways);
    }

    private static int evaluateExpWays(String exp) {
        Long[][][] memTable = new Long[exp.length()][exp.length()][2];
        return (int) evaluateExpressionWays(exp, 0, exp.length() - 1, 1, memTable);
    }

    private static long evaluateExpressionWays(String exp, int i, int j, int isTrue, Long[][][] memTable) {
        if(i>j) {
            return 0;
        }
        if(i==j) {
            if(isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if(memTable[i][j][isTrue] != null) {
            return memTable[i][j][isTrue];
        }
        long ways = 0;
        for(int k=i+1;k<j;k=k+2) {
            long leftTrue = evaluateExpressionWays(exp, i, k-1, 1, memTable);
            long leftFalse = evaluateExpressionWays(exp, i, k-1, 0, memTable);
            long rightTrue = evaluateExpressionWays(exp, k+1, j, 1, memTable);
            long rightFalse = evaluateExpressionWays(exp, k+1, j, 0, memTable);
            char operator = exp.charAt(k);
            if(operator == '&') {
                if(isTrue == 1) {
                    ways = (ways + (leftTrue * rightTrue) % MOD) % MOD;
                } else {
                    ways = (ways +
                            (leftTrue * rightFalse) % MOD +
                            (leftFalse * rightTrue) % MOD +
                            (leftFalse * rightFalse) % MOD) % MOD;
                }
            } else if (operator == '|') {
                if(isTrue == 1) {
                    ways = (ways +
                            (leftTrue * rightFalse) % MOD +
                            (leftFalse * rightTrue) % MOD +
                            (leftTrue * rightTrue) % MOD) % MOD;
                } else {
                    ways = (ways + (leftFalse * rightFalse) % MOD) % MOD;
                }
            } else {
                if(isTrue == 1) {
                    ways = (ways +
                            (leftTrue * rightFalse) % MOD +
                            (leftFalse * rightTrue) % MOD) % MOD;
                } else {
                    ways = (ways +
                            (leftTrue * rightTrue) % MOD +
                            (leftFalse * rightFalse) % MOD) % MOD;
                }
            }
        }
        memTable[i][j][isTrue] = ways;
        return ways;
    }
}
