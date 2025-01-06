package Recurssion;
import java.util.*;

public class FindCombinationSum {
    public static void main(String[] args) {
        int arr[] = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(arr, target);
        System.out.println("Combinations are: ");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    // Backtracking function to find combinations
    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base case: if we've considered all elements
        if (target == 0) {
            ans.add(new ArrayList<>(ds));  // Add the current combination
            return;
        }
        if (ind == arr.length) {
            return;  // If no more elements to consider
        }

        // Include the current element if it's smaller than or equal to the target
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            // Recur with the same index (since we can reuse the same number)
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.removeLast();  // Backtrack
        }

        // Exclude the current element and move to the next index
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    // Wrapper for the backtracking function
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
