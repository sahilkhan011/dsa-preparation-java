package recurssion;

import java.util.HashMap;
import java.util.Map;

public class FindFibonacci {

    public static void main(String[] args) {
        // Example 1: Naive Recursive Solution (not optimized)
        int ans = findFibonacci(5);
        System.out.println(ans);  // Output the 5th Fibonacci number

        // Example 2: Optimized solution using Memoization (Dynamic Programming)
        // Memoization map to store the results of previously computed Fibonacci numbers
        Map<Integer, Integer> memo = new HashMap<>();
        int result = findFibonacciUsingDp(5, memo);
        System.out.println(result);  // Output the 5th Fibonacci number using memoization
    }

    // Naive recursive solution for Fibonacci
    // This is a simple, but inefficient approach with exponential time complexity
    private static int findFibonacci(int i) {
        // Base case: If the index is 0 or 1, return the index value itself
        // F(0) = 0 and F(1) = 1
        if (i == 0 || i == 1) return i;

        // Recursive case: F(i) = F(i-1) + F(i-2)
        // Calls itself twice, which leads to redundant calculations
        return findFibonacci(i - 1) + findFibonacci(i - 2);
    }

    // Optimized solution using Memoization (Dynamic Programming)
    // This solution avoids redundant calls by storing previously calculated results
    private static int findFibonacciUsingDp(int i, Map<Integer, Integer> memo) {
        // Base case: If the index is less than 2, simply return the index value (F(0) = 0, F(1) = 1)
        if (i < 2) return i;

        // Check if the result for this Fibonacci number is already computed and stored in the memo map
        if (memo.containsKey(i)) {
            return memo.get(i);  // If found, return the stored result
        }

        // If not found in the memo, compute the Fibonacci number recursively
        // This is the recursive formula: F(i) = F(i-1) + F(i-2)
        int result = findFibonacciUsingDp(i - 1, memo) + findFibonacciUsingDp(i - 2, memo);

        // Store the result in the memoization map to avoid recomputation
        memo.put(i, result);

        // Return the computed Fibonacci number
        return result;
    }
}
