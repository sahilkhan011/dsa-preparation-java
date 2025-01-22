package recurssion;
import java.util.*;

public class LetterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans; // Return empty list if input is empty
        }

        StringBuilder ds = new StringBuilder();

        // Mapping digits to corresponding letters
        String[] mp = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        // Start the recursive function
        findAllPosibleCombinations(0, digits, mp, ds, ans);

        return ans; // Return the result list
    }

    private void findAllPosibleCombinations(int ind, String digits, String[] mp, StringBuilder ds, List<String> ans) {
        // If we've reached the length of the digits, add the current combination to the result
        if (ind == digits.length()) {
            ans.add(ds.toString());
            return;
        }

        // Get the current digit and map it to its corresponding string of letters
        int digit = digits.charAt(ind) - '0'; // subtract by '0' because its ASCII value
        String digitString = mp[digit];

        // Loop through all possible letters for the current digit
        for (int i = 0; i < digitString.length(); i++) {
            ds.append(digitString.charAt(i)); // Add letter to the current combination
            findAllPosibleCombinations(ind + 1, digits, mp, ds, ans); // Recurse for the next digit
            ds.deleteCharAt(ds.length() - 1); // Remove last added letter (backtrack)
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber solution = new LetterCombinationOfPhoneNumber();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }
}
