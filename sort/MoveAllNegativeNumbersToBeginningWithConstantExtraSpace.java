public class MoveAllNegativeNumbersToBeginningWithConstantExtraSpace {
  public static void main(String[] args) {
        int[] input = {-2, 0, 9, -1, 3, 0, 100, -7, 10, 23, -99};
        moveAllNegativeNumberToBeginningPartitionApproach(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    // QuickSort partition approach
    public static void moveAllNegativeNumberToBeginningPartitionApproach(int[] arr) {
        int j=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] < 0) {
                if(i!=j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    // Two pointer approach
    public static void moveAllNegativeNumberToBeginningTwoPointerApproach(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<=right) {
            if(arr[left] < 0 && arr[right] < 0) {
                left++;
            } else if(arr[left] > 0 && arr[right] < 0) {
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            } else if(arr[left] > 0 && arr[right] > 0) {
                right--;
            } else {
                left++;
                right--;
            }
        }
    }
}
