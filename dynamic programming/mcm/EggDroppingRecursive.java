package com.akash.maharana.dp.mcm;

public class EggDroppingRecursive {
    public static void main(String[] args) {
        int noOfEggs = 2, noOfFloor = 10;
        System.out.print("Minimum number of "
                + "trials in worst case with " + noOfEggs
                + " eggs and " + noOfFloor + " floors is "
                + eggDrop(noOfEggs, noOfFloor));
    }

    private static int eggDrop(int noOfEggs, int noOfFloor) {
        if(noOfFloor == 0 || noOfFloor == 1) {
            return noOfFloor;
        }
        if(noOfEggs == 1){
            return noOfFloor;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=noOfFloor;i++) {
            int temp = 1 + Math.max(eggDrop(noOfEggs-1, i-1), eggDrop(noOfEggs, noOfFloor-i));
            min = Math.min(min, temp);
        }
        return min;
    }
}
