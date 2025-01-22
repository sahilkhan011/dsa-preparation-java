package numberandarray;

public class NextGreaterPermutation {

    public void reverseArray(int[] nums, int left, int right) {
        // Swap the elements until left and right pointers meet
        while (left < right) {
            // Swap nums[left] with nums[right]
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // Move the pointers
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int stI = -1;

        // Step 1: Find the first index where nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                stI = i;
                break;
            }
        }

        // Step 2: If no such index exists, the array is in descending order, reverse it
        if (stI == -1) {
            reverseArray(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the largest index j such that nums[j] > nums[stI]
        for (int i = n - 1; i > stI; i--) {
            if (nums[i] > nums[stI]) {
                // Swap nums[i] and nums[stI]
                int temp = nums[i];
                nums[i] = nums[stI];
                nums[stI] = temp;
                break;
            }
        }

        // Step 4: Reverse the elements from stI + 1 to the end of the array
        reverseArray(nums, stI + 1, n - 1);
    }

}
