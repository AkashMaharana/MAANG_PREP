class PermutationWithCaseChange {
    public static void main(String[] args) {
        String input = "abc";
        String output = "";
        permutationWithCaseChange(input, "");
    }
    
    private static void permutationWithCaseChange(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        String output1 = output + (input.charAt(0) + "").toLowerCase();
        String output2 = output + (input.charAt(0) + "").toUpperCase();
        permutationWithCaseChange(input.substring(1), output1);
        permutationWithCaseChange(input.substring(1), output2);
        return;
    }
}
