package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr =  {6,54,58,47,12,45,6,95,3};
        System.out.println("Before Sorting : "+ Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After Sorting : "+ Arrays.toString(arr));

    }

    private static void selectionSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {

            int min = i;

            for (int j = i+1; j < size; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }

            // swap min with i
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }

        }
    }
}
