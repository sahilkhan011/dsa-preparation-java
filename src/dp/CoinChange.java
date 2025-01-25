package dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // DP array to store the minimum coins required for each amount up to the target
        int[] dp = new int[amount + 1];

        // Initialize the dp array with a large value (amount + 1 represents "infinity")
        // as no solution can be larger than the amount itself.
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;  // Set the initial value to a large number
        }

        // Base case: 0 amount requires 0 coins
        dp[0] = 0;

        // Fill the dp array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still the initial value, it means it's impossible to form the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();

        // Test case 1
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins for amount " + amount + ": " + solution.coinChange(coins, amount));

        // Test case 2 (no possible solution)
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Minimum coins for amount " + amount2 + ": " + solution.coinChange(coins2, amount2));

        // Test case 3 (base case)
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Minimum coins for amount " + amount3 + ": " + solution.coinChange(coins3, amount3));
    }
}
