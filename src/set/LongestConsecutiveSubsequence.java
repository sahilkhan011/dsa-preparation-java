package set;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) { // Start of a new sequence
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

    public static void main(String[] args) {
        int[] arr = {45, 2, 3, 47, 48, -25, 46};
        System.out.println(longestConsecutive(arr)); // Output: 4
    }
}
