public class MergeSort {
    public static void main(String[] args) {
        int[] input = {-2, 0, 9, -1, 3, -7, 10, 23};
        if (input.length == 0 || input.length == 1) {
            System.out.println("Array is empty or sorted");
        }
        mergeSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int m = mid - low + 1;
        int n = high - mid;
        int[] temp1 = new int[m];
        int[] temp2 = new int[n];
        for (int i = 0; i < m; i++) {
            temp1[i] = arr[low + i];
        }
        for (int i = 0; i < n; i++) {
            temp2[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < m && j < n) {
            if (temp1[i] <= temp2[j]) {
                arr[k] = temp1[i];
                i++;
            } else {
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            arr[k] = temp1[i];
            i++;
            k++;
        }
        while (j < n) {
            arr[k] = temp2[j];
            k++;
            j++;
        }

    }
}
