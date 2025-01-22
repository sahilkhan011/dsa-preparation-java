package recurssion;

public class PowerSetInString {

    // Function to find all possible subsequences
    public static void findAllPossibleStrings(int i, StringBuilder s, StringBuilder f) {
        // Base case: if we've processed all characters in the string
        if (i == s.length()) {
            // Print the current subsequence (StringBuilder is converted to String)
            System.out.print(f + " ");
            return;
        }

        // Recursive case 1: Pick up
        f.append(s.charAt(i));
        findAllPossibleStrings(i + 1, s, f);

        // Backtrack: Remove the last character to explore the not pick up possibility
        f.deleteCharAt(f.length() - 1);

        // Recursive case 2: Not pick up
        findAllPossibleStrings(i + 1, s, f);
    }

    public static void main(String args[]) {
        StringBuilder s = new StringBuilder("abc");
        StringBuilder f = new StringBuilder();
        System.out.println("All possible subsequences are: ");
        findAllPossibleStrings(0, s, f);
    }
}
