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

    public static void main(String[] args) {
        int[] stones = {10, 20, 50, 40, 35, 50};  // Example input
        int n = stones.length;

        // Call the recursive solution with memoization and print the result
        System.out.println("Recursive (with memoization) solution result: " + recurse(0, n - 1, stones));
    }
}
