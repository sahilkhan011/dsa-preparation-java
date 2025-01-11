package BitManipulation;

import java.util.*;

public class PowerSetInString {

    public static ArrayList<String> AllPossibleStrings(String s) {
        int n = s.length();
        int nn = 1 << n;  // nn = 2^n, total number of subsets
        ArrayList<String> ans = new ArrayList<>(nn - 1);  // List to store subsets

        // Iterate over all numbers from 1 to (2^n - 1) to generate non-empty subsets
        for (int num = 1; num < nn; num++) {  // Start from 1 to skip the empty subset
            StringBuilder subset = new StringBuilder();

            // Check each bit of num to decide whether to include s[i] in the subset
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    subset.append(s.charAt(i));  // Append character if the bit is set
                }
            }

            ans.add(subset.toString());  // Add the subset to the answer list
        }

        return ans;
    }

    public static void main(String[] args) {
        String input = "abc";
        ArrayList<String> subsets = AllPossibleStrings(input);

        // Print all subsets (power set)
        for (String subset : subsets) {
            System.out.println(subset);
        }
    }
}
