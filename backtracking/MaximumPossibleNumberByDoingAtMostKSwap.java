class MaximumPossibleNumberByDoingAtMostKSwap {
    
    private static String max = "";
    
    public static void main(String[] args) {
        String input = "129814999";
        int k = 4;
        maximumPossibleNumber(input.toCharArray(), k);
        System.out.println(max);
    }
    
    private static void maximumPossibleNumber(char[] arr, int k) {
        if(k == 0) {
            return;
        }
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] > arr[i]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    if(max.compareTo(new String(arr)) < 0) {
                        max = new String(arr);
                    }
                    maximumPossibleNumber(arr, k-1);
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return;
    }
}
