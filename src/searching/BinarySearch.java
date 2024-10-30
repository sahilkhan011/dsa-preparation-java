package searching;
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {5, 7, 8, 11, 15, 16};

        int target = 11;
        int res = binarySearch(nums, target);

        if (res != -1) {
            System.out.println("Element found at Index : " + res);
        } else {
            System.out.println("Element Not Found.");
        }
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // right is inclusive

        while (left <= right) {
            int mid = (left +  right) / 2; // Calculate midpoint

            // Compare middle element with target
            if (nums[mid] == target) {
                return mid; // Target found at index mid.
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half.
            } else {
                right = mid - 1; // Target is in the left half.
            }
        }
        return -1; // Target not found
    }

}
