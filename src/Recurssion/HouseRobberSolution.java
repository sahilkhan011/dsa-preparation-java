package Recurssion;

public class HouseRobberSolution {
    // Recursive solution .....
    public int robRecursive(int[] nums, int index) {
        // Base case: if the index goes out of bounds, return 0
        if (index >= nums.length) {
            return 0;
        }

        // Recursive case:
        // 1. Rob the current house (nums[index]) and skip the next house (index + 2)
        // 2. Don't rob the current house and move to the next one (index + 1)
        int robCurrentHouse = nums[index] + robRecursive(nums, index + 2);
        int skipCurrentHouse = robRecursive(nums, index + 1);

        // Return the maximum of robbing or skipping the current house
        return Math.max(robCurrentHouse, skipCurrentHouse);
    }

    // Optimal solution....
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // Initialize an array to store the maximum money that can be robbed up to each house
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0]; // Only one house to rob
        if (n > 1) {
            dp[1] = Math.max(nums[0], nums[1]); // Choose the maximum between the first two houses
        }
        // Fill in the dp array with the maximum money up to each house
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1]; // The last element contains the result
    }
}
