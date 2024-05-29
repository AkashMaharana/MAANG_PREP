class TrappingRainWater {
    public static void main(String[] args) 
    { 
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(totalWaterTrapped(arr)); 
    }
    
    private static int totalWaterTrapped(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        right[arr.length-1] = arr[arr.length-1];
        for(int i=1;i<left.length;i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }
        for(int i=right.length-2;i>=0;i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }
        int totalWaterContent = 0;
        for(int i=0;i<arr.length;i++) {
            totalWaterContent = totalWaterContent + (Math.min(left[i], right[i]) - arr[i]);
        }
        return totalWaterContent;
    }
}
