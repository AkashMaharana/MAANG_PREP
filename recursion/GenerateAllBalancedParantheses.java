class GenerateAllBalancedParantheses {
    public static void main(String[] args) {
        int input = 3;
        String output = "(";
        int open = input - 1;
        int close = input;
        generateAllBalancedParantheses(open, close, output);
    }
    
    private static void generateAllBalancedParantheses(int open, int close, String output) {
        if(open ==0 && close == 0) {
            System.out.println(output);
            return;
        }
        if(open != 0) {
            String output1 = output + "(";
            generateAllBalancedParantheses(open - 1, close, output1);
        }
        if(close > open) {
            String output2 = output + ")";
            generateAllBalancedParantheses(open, close - 1, output2);
        }
        return;
    }
}
