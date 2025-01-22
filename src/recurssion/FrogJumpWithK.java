package recurssion;

public class FrogJumpWithK {

    // Recursive approach with k steps allowed
    public static int recurse(int i, int k, int n, int[] stones) {
        // Base case: If frog reaches the last stone, no cost to move further
        if (i == n) return 0;

        // If frog goes beyond the last stone, return a large value
        if (i > n) return Integer.MAX_VALUE;

        // Initialize the result as a very large number (we are looking for minimum)
        int result = Integer.MAX_VALUE;

        // Loop through all possible jumps from i+1 to i+k
        for (int j = 1; j <= k; j++) {
            // Ensure the jump does not exceed the last stone
            if (i + j <= n) {
                // Calculate the cost for this jump and recursively find the minimum cost
                result = Math.min(result, Math.abs(stones[i] - stones[i + j]) + recurse(i + j, k, n, stones));
            }
        }

        // Return the minimum cost found
        return result;
    }

    // Dynamic Programming approach
    public static int solveUsingDp(int n, int k, int[] stones) {
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
            // Check all possible jumps from stone j to j+1, j+2, ..., j+k
            for (int c = 1; c <= k; c++) {
                // Ensure the jump does not exceed the last stone
                if (j + c < n) {
                    // Update the dp value for stone j+c to the minimum cost
                    dp[j + c] = Math.min(dp[j + c], dp[j] + Math.abs(stones[j] - stones[j + c]));
                }
            }
        }

        // Return the minimum cost to reach the last stone (stone n-1)
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // Example input: stones array with values representing the cost at each stone
        int[] stones = {10, 20, 50, 40, 35, 50};
        int n = stones.length;  // Number of stones

        // Call the recursive solution and print the result
        // For recursive approach, frog can jump up to 3 stones ahead at each step
        System.out.println("Recursive solution result: " + recurse(0, 3, n - 1, stones));

        // Call the dynamic programming solution and print the result
        // For DP approach, frog can jump up to 3 stones ahead at each step
        System.out.println("Dynamic Programming solution result: " + solveUsingDp(n, 3, stones));
    }
}
