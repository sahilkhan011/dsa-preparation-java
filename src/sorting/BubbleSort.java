package sorting;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr =  {6,54,58,47,12,45,6,95,3};
        System.out.println("Before Sorting : "+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Sorting : "+ Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {

            int flag =0;

            for (int j = 0; j < size-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag++;
                }
            }

            if (flag == 0) {
                return;
            }
        }
    }
}
