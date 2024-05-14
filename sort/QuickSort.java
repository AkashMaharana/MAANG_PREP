
public class QuickSort {
    public static void main(String[] args) {
        int[] input = {-2, 0, 9, -1, 3, -7, 10, 23};
        if (input.length == 0 || input.length == 1) {
            System.out.println("Array is empty or sorted");
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = getPartitionIndex(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }
    
    public static int getPartitionIndex(int[] arr, int low, int high) {
        int partitionIndex = low;
        int pivot =arr[high];
        for(int i=low;i<high;i++) {
            if(arr[i]<=pivot) {
                int temp = arr[i];
                arr[i] = arr[partitionIndex];
                arr[partitionIndex] = temp;
                partitionIndex++;
            }
        }
        int temp1 = arr[partitionIndex];
        arr[partitionIndex] = arr[high];
        arr[high] = temp1;
        return partitionIndex;
    }

}
