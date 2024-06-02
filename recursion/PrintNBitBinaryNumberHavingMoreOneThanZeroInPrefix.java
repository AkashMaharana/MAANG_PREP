class PrintNBitBinaryNumberHavingMoreOneThanZeroInPrefix {
    public static void main(String[] args) {
        int length = 4;
        String output = "";
        int one = 0;
        int zero = 0;
        printNBitBinaryNumberPrefix(length, zero, one, output);
    }
    
    private static void printNBitBinaryNumberPrefix(int length, int zero, int one, String output) {
        if(length == 0) {
            System.out.println(output);
            return;
        }
        String output1 = output + "1";
        printNBitBinaryNumberPrefix(length - 1, zero, one + 1, output1);
        if(one > zero) {
            String output2 = output + "0";
            printNBitBinaryNumberPrefix(length - 1, zero + 1, one, output2);
        }
        return;
    }
}
