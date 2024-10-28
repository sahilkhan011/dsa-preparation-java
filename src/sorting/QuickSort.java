package sorting;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 54, 58, 47, 12, 45, 95, 3};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // if arr[j]  smaller than pivot...
                i++;

                // Swap arr[i] and arr[j]
                if(i != j){ // avoid self swapping

                    //System.out.println("Internal Swapping "+arr[i]+" with "+ arr[j] +", Array : " + Arrays.toString(arr));

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    //System.out.println("Now  Array : " + Arrays.toString(arr));

                }
            }
        }

        // Move pivot to its correct position
        if(i+1 != high){ // avoid self swapping.

            //System.out.println("Swapping "+arr[i+1]+" with "+ arr[high] +", Array : " + Arrays.toString(arr));

            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            //System.out.println("Now  Array : " + Arrays.toString(arr));

        }
        return i + 1; // Return the pivot index

        // Reference Video :
        // https://youtube.com/shorts/-5cEMbsyMgs?si=Xe2guUQVBlww3FUz

    }
}
