package sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {6, 54, 58, 47, 12, 45, 95, 3};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        countSort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }

    /**
     * Counting Sort Algorithm
     *
     * This is one of the fastest algorithms for sorting when the range of input
     * values is known and limited.
     *
     * Note: This algorithm works only for non-negative integers because it
     * relies on index values in the counting array.
     *
     * Space complexity can be a concern if the range of input values is
     * significantly larger than the number of elements being sorted.
     */
    private static void countSort(int[] arr) {
        int max = findMax(arr);

        // Initialize count array with size max + 1
        int[] count = new int[max + 1];

        // Iterate through arr and increase corresponding index values
        for (int i : arr) {
            if (i >= 0) { // Ensure the index is non-negative
                count[i]++; // Increment the count at the corresponding index
            }
        }

        int f = 0;
        // Populate the original array using the count array
        for (int i = 0; i < count.length; i++) {
            int j = count[i];
            while (j > 0) {
                arr[f++] = i; // Use the index i to fill the sorted array
                j--;
            }
        }
    }

    private static int findMax(int[] arr) {
        // Check if the array is empty
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        // Initialize max with the first element
        int max = arr[0];
        // Iterate through the array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if current element is greater
            }
        }
        return max; // Return the maximum value found
    }
}
