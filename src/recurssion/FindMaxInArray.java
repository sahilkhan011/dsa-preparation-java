package recurssion;

public class FindMaxInArray {

    public static void main(String[] args) {
        // Example array
        int[] arr = {3, 5, 7, 2, 8, 6, 1};

        // Call the recursive function to find the maximum
        int max = findMax(arr, 0);

        // Output the result
        System.out.println("The maximum value in the array is: " + max);
    }

    // Recursive method to find the maximum in the array
    private static int findMax(int[] arr, int index) {
        // Base case: If we reach the end of the array, return the last element
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Recursively find the maximum in the remaining array
        int maxOfRest = findMax(arr, index + 1);

        // Compare the current element with the maximum of the rest of the array
        return Math.max(arr[index], maxOfRest);
    }
}
