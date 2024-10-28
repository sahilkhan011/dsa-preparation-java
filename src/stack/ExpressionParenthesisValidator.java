package stack;

public class ExpressionParenthesisValidator {

        public static void main(String[] args) {
            String expression = "(({5*5}+5-5))";
            boolean isValid = isExpressionValid(expression);

            if (isValid) {
                System.out.println("Expression is valid");
            } else {
                System.out.println("Expression is not valid");
            }
        }

        private static boolean isExpressionValid(String expression) {
            // Convert expression into character array for easier traversal
            char[] expArr = expression.toCharArray();
            // Stack to keep track of opening brackets
            StackWithArray<Character> stack = new StackWithArray<>(expression.length());

            // Iterate through each character in the expression
            for (char ch : expArr) {
                // If an opening bracket is found, push it onto the stack
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                }
                // If a closing bracket is found, check for matching opening bracket
                else if (ch == ')' || ch == ']' || ch == '}') {
                    // Determine the corresponding opening bracket
                    char expectedOpeningBracket = (ch == ')') ? '(' : (ch == '}') ? '{' : '[';

                    // If stack is empty, it means there's an unmatched closing bracket
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // If the top of the stack does not match the expected opening bracket, it's invalid
                    else if (stack.peek() != expectedOpeningBracket) {
                        return false;
                    }
                    // Pop the matched opening bracket from the stack
                    stack.pop();
                }
            }

            // If the stack is empty, all brackets were matched; otherwise, it's invalid
            return stack.isEmpty();
        }


}
