package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr =  {6,54,58,47,12,45,6,95,3};
        System.out.println("Before Sorting : "+ Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After Sorting : "+ Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {// Start from the second element

            int key = arr[i];
            int j = i - 1;

            // Shift elements of arr[0..i-1], that are greater than key, to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
