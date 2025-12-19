package string;

public class AllPosibleStrings {
    static void solve(int i, String s, StringBuilder f) {
        if (i == s.length()) {
            System.out.print(f+" ");
            return;
        }
        // Step 1: Pick the character
        f.append(s.charAt(i));
        solve(i + 1, s, f);

        // Step 2: Backtrack (remove last character)
        f.deleteCharAt(f.length() - 1);

        // Step 3: Not pick the character
        solve(i + 1, s, f);
    }
    public static void main(String args[]) {
        String s = "abc";
        StringBuilder f = new StringBuilder("");
        System.out.println("All possible subsequences are: ");
        solve(0, s, f);
    }
}
