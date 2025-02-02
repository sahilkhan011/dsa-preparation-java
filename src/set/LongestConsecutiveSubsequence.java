package set;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    // **Approach 1: HashSet-based Solution (Efficient, O(N))**
    public static int longestConsecutiveHashSet(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) { // Start of a sequence
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // **Approach 2: Sorting-based Solution (Less Efficient, O(N log N))**
    public static int longestConsecutiveSorting(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums); // O(N log N)
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; // Ignore duplicates
            } else if (nums[i] == nums[i - 1] + 1) {
                currentLength++; // Continue sequence
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1; // Reset sequence
            }
        }

        return Math.max(maxLength, currentLength);
    }

    // **Main Method to Test Both Approaches**
    public static void main(String[] args) {
        int[] arr = {45, 2, 3, 47, 48, -25, 46};

        System.out.println("HashSet Approach: " + longestConsecutiveHashSet(arr)); // Output: 4
        System.out.println("Sorting Approach: " + longestConsecutiveSorting(arr)); // Output: 4
    }
}
