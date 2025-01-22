package Recurssion;

import java.util.HashMap;
import java.util.Map;

public class CoinSystemProblem {
    // Memoization map to store results for each amount (val)
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = {1, 5, 7};
        int result = findMinimumCoins(11, coins);
        System.out.println(result);  // This should output the minimum number of coins to form 11
    }

    private static int findMinimumCoins(int val, int[] coins) {
        // Start the recursion with memoization
        int result = recurse(val, coins);
        return result == Integer.MAX_VALUE ? -1 : result;  // If no valid solution, return -1
    }

    private static int recurse(int val, int[] coins) {
        // Base case: if the value is 0, no more coins are needed
        if (val == 0) {
            return 0;
        }

        // If we've already computed the result for this value, return the memoized result
        if (memo.containsKey(val)) {
            return memo.get(val);
        }

        // Initialize the minimum number of coins required to a large value
        int minCoins = Integer.MAX_VALUE;

        // Try every coin in the array
        for (int coin : coins) {
            if (coin <= val) {
                // Recursively find the minimum coins for the remaining value
                int res = recurse(val - coin, coins);

                // If a valid solution is found, update the minimum coins required
                if (res != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, res + 1);  // Add one coin to the result
                }
            }
        }

        // Store the computed result in the memoization map
        memo.put(val, minCoins);

        return minCoins;
    }
}
