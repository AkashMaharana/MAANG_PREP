class PrintAllPermutationsWIthUnderscoreBetweenCharacters {
    public static void main(String[] args) {
        String input = "abc";
        permutationWithSpaces(input.substring(1), input.substring(0,1));
    }
    
    private static void permutationWithSpaces(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        String output1 = output + input.charAt(0);
        String output2 = output + "_" + input.charAt(0);
        permutationWithSpaces(input.substring(1), output1);
        permutationWithSpaces(input.substring(1), output2);
        return;
    }
}
