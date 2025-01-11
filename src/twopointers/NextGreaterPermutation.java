package twopointers;

public class NextGreaterPermutation {
    // reverse array using two pointers
    public void reverseArray(int[] arr,int left){
        int right = arr.length - 1;
        while(left<right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }
    }

    public void nextPermutation(int[] arr) {
        int i = arr.length - 2;

        while(i >= 0 && arr[i]>arr[i+1]){
            i--;
        }
        if(i>=0){
            int j = arr.length - 1;
            while(j > i){
                if(arr[j]>arr[i]){
                    // swap it
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    break;
                }
                j--;
            }
        }
        reverseArray(arr,i+1);
    }

    public static void main(String[] args) {
        NextGreaterPermutation np = new NextGreaterPermutation();

        // Test case 1: A typical array
        int[] arr1 = {1, 2, 3};
        System.out.println("Original: ");
        printArray(arr1);
        np.nextPermutation(arr1);
        System.out.println("Next permutation: ");
        printArray(arr1);

        // Test case 2: Array in descending order (edge case)
        int[] arr2 = {3, 2, 1};
        System.out.println("\nOriginal: ");
        printArray(arr2);
        np.nextPermutation(arr2);
        System.out.println("Next permutation: ");
        printArray(arr2);

        // Test case 3: Array with duplicate elements
        int[] arr3 = {1, 5, 1};
        System.out.println("\nOriginal: ");
        printArray(arr3);
        np.nextPermutation(arr3);
        System.out.println("Next permutation: ");
        printArray(arr3);

        // Test case 4: Array with a single element (edge case)
        int[] arr4 = {1};
        System.out.println("\nOriginal: ");
        printArray(arr4);
        np.nextPermutation(arr4);
        System.out.println("Next permutation: ");
        printArray(arr4);
    }
    // Helper method to print the array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
