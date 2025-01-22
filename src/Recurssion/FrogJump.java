package Recurssion;

import java.util.Arrays;

public class FrogJump {

    // Original recursive solution (without modification)
    public static int recurse(int i, int n, int[] stones) {
        // Base case: If frog reaches the last stone, no cost to move further
        if (i == n) return 0;

        // If frog goes beyond the last stone, return a large value
        if (i > n) return Integer.MAX_VALUE;

        int firstPath = Integer.MAX_VALUE;
        int secondPath = Integer.MAX_VALUE;

        // If a jump to i+1 is possible, calculate the cost of jumping there
        if (i + 1 <= n) {
            firstPath = Math.abs(stones[i] - stones[i + 1]) + recurse(i + 1, n, stones);
        }

        // If a jump to i+2 is possible, calculate the cost of jumping there
        if (i + 2 <= n) {
            secondPath = Math.abs(stones[i] - stones[i + 2]) + recurse(i + 2, n, stones);
        }

        // Return the minimum cost from both paths
        return Math.min(firstPath, secondPath);
    }

    // Dynamic Programming approach
    public static int solveUsingDp(int n, int[] stones) {
        // DP array to store the minimum cost to reach each stone
        int[] dp = new int[n];

        // Base case: no cost to start at stone 0
        dp[0] = 0;

        // Initialize all other dp values to a very large number (maximum cost)
        for (int j = 1; j < n; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        // Loop through each stone to compute minimum cost
        for (int j = 0; j < n - 1; j++) {
            // If jumping to stone j+1 is possible and within bounds
            if (j + 1 < n) {
                dp[j + 1] = Math.min(dp[j + 1], dp[j] + Math.abs(stones[j] - stones[j + 1]));
            }
            // If jumping to stone j+2 is possible and within bounds
            if (j + 2 < n) {
                dp[j + 2] = Math.min(dp[j + 2], dp[j] + Math.abs(stones[j] - stones[j + 2]));
            }
        }

        // Return the minimum cost to reach the last stone (stone n-1)
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] stones = {10, 20, 50, 40, 35, 50};  // Example input
        int n = stones.length;

        // Call the recursive solution with memoization and print the result
        System.out.println("Recursive (with memoization) solution result: " + recurse(0, n - 1, stones));

        // Call the dynamic programming solution and print the result
        System.out.println("Dynamic Programming solution result: " + solveUsingDp(n, stones));
    }
}
