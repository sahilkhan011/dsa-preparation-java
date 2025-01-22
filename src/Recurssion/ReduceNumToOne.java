package Recurssion;

import java.util.HashMap;
import java.util.Map;

public class ReduceNumToOne {
    // Memoization map to store the results for subproblems
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int steps = minStepsForReduceNumberToOne(45); // Starting from 45
        System.out.println(steps);
    }

    private static int minStepsForReduceNumberToOne(int num) {
        // If the result is already calculated, return it from memo
        if (num == 1) {
            return 0;
        }

        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        int result = Integer.MAX_VALUE;

        // Try dividing by 3 if divisible
        if (num % 3 == 0) {
            result = Math.min(result, minStepsForReduceNumberToOne(num / 3) + 1);
        }

        // Try dividing by 2 if divisible
        if (num % 2 == 0) {
            result = Math.min(result, minStepsForReduceNumberToOne(num / 2) + 1);
        }

        // Try subtracting 1
        result = Math.min(result, minStepsForReduceNumberToOne(num - 1) + 1);

        // Store the result in memo before returning it
        memo.put(num, result);

        return result;
    }
}
