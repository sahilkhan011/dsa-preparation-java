package dp;

public class KnapSackProblem {

    // Function to solve the 0/1 Knapsack problem
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dp table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                // If no item or capacity is 0, the value is 0
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    // If the current item's weight is less than or equal to the capacity
                    // Either include the item or don't
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // If the item cannot be included, exclude it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // Example items (values and weights)
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        int maxValue = knapsack(values, weights, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}

