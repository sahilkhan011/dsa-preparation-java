package string;

public class RemoveOuterParentheses {
    // Input: s = "(()())(())"
    // Output: "()()()"
    public static void main(String[] args) {
        String s = "(()())(())";
        String result = removeOuterParentheses(s);
        System.out.println(result); // Output: "()()()"
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    result.append(c); // Append if it's not an outer '('
                }
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance > 0) {
                    result.append(c); // Append if it's not an outer ')'
                }
            }
        }

        return result.toString();
    }
}
