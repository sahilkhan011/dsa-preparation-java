package searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {5, 7, 8, 11, 15, 16};

        int target = 11;
        int res = linearSearch(nums, target);

        if (res != -1) {
            System.out.println("Element found at Index : " + res);
        } else {
            System.out.println("Element Not Found.");
        }
    }

    private static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
