package numberandarray;

import java.util.Arrays;

public class MovesNonZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12}; // Example input array
        System.out.println("Original array: " + Arrays.toString(nums));

        moveZeroes(nums); // Call the method to move zeroes

        System.out.println("Modified array: " + Arrays.toString(nums)); // Print the modified array
    }

    public static void moveZeroes(int[] nums) {
        int j = -1; // Pointer for the position of non-zero elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (++j != i) { // Only swap if j and i are different
                    nums[j] = nums[i];
                    nums[i] = 0; // Set the current position to zero
                }
            }
        }
    }
}
