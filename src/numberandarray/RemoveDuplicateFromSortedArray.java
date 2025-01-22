package numberandarray;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray remover = new RemoveDuplicateFromSortedArray();

        // Example 1
        int[] nums1 = {1, 1, 2};
        int count1 = remover.removeDuplicates(nums1);
        System.out.println("Example 1: " + Arrays.toString(Arrays.copyOf(nums1, count1)) + ", Count: " + count1);

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 2, 2, 3, 3, 4};
        int count2 = remover.removeDuplicates(nums2);
        System.out.println("Example 2: " + Arrays.toString(Arrays.copyOf(nums2, count2)) + ", Count: " + count2);
    }

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
