package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 54, 58, 47, 12, 45, 95, 3,76};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        mergeSort(arr,0,arr.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            // Sort the two halves
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            // Merge the sorted halves
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        // Sizes of the two subarrays
        int n1 = mid - l + 1;
        int n2 = r - mid;

        // Create temporary arrays
        int[] lArr = new int[n1];
        int[] rArr = new int[n2];
        // Copy data to temporary arrays
        for (int i = 0; i < n1 + n2; i++) {
            if (i < n1) {
                lArr[i] = arr[l + i];
            } else {
                rArr[i - n1] = arr[mid + 1 + (i - n1)];
            }
        }

        // Merge the temporary arrays back into arr[l to r]
        int i = 0, j = 0;
        for (int k = l; k <= r; k++) {
            if (i < n1 && (j >= n2 || lArr[i] <= rArr[j])) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
        }
    }
}
