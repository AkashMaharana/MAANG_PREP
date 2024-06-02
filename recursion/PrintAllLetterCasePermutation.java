class PrintAllLetterCasePermutation {
    public static void main(String[] args) {
        String input = "a1b2c";
        String output = "";
        letterCasePermutation(input, "");
    }
    
    private static void letterCasePermutation(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        String output1 = "";
        String output2 = "";
        if(Character.isDigit(input.charAt(0))) {
            output1 = output + input.charAt(0);
            output2 = output + input.charAt(0);
            letterCasePermutation(input.substring(1), output1);
        } else {
            output1 = output + (input.charAt(0) + "").toLowerCase();
            output2 = output + (input.charAt(0) + "").toUpperCase();
            letterCasePermutation(input.substring(1), output1);
            letterCasePermutation(input.substring(1), output2);
        }
        return;
    }
}
