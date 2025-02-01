package stack;
import java.util.Stack;

public class ParenthesesValidation {
    public static void main(String[] args) {
        boolean isValid = isParenthesesValid("(){}[]");
        System.out.println(isValid);  // Output: true
    }

    private static boolean isParenthesesValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Push opening parentheses onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // If a closing parenthesis is encountered
            else if (c == ')' || c == '}' || c == ']') {
                // Check if the stack is empty before popping
                if (stack.isEmpty())
                    return false;  // No matching opening parenthesis

                // Pop the top of the stack and check if it matches the current closing parenthesis
                char pop = stack.pop();
                if (c == ')' && pop != '(') return false;
                if (c == ']' && pop != '[') return false;
                if (c == '}' && pop != '{') return false;
            }
        }

        // Ensure the stack is empty at the end
        return stack.isEmpty();
    }
}

