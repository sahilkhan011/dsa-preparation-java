package stack;
public class InfixToPostFix {

    String op1Arr = "+-";
    String op2Arr = "*/";

    public static void main(String[] args) {
        String infixExp = "a*b+c/d";
        String postfixExp = infixToPostFix(infixExp);
        System.out.println(postfixExp);
    }

    // Function to return precedence of operators
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    private static String infixToPostFix(String infixExp) {
        String postfixExp = "";
        char[] infixArr = infixExp.toCharArray();
        // System.out.println(infixArr.length);
        StackWithArray<Character> stack = new StackWithArray<Character>(infixArr.length);
        for (int i = 0; i < infixArr.length; i++) {
            char c = infixArr[i];
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                if (stack.isEmpty() || prec(c) > prec(stack.peek())) {
                    // System.out.println("item pushed " + c);
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && prec(stack.peek()) >= prec(c)) {
                        postfixExp = postfixExp + stack.pop();
                        // stack.pop();
                        // System.out.println("item poped " + stack.pop());
                    }
                    // System.out.println("item pushed " + c);
                    stack.push(c);
                }
            } else {
                postfixExp = postfixExp + c;
            }

        }
        while (!stack.isEmpty()) {
            postfixExp = postfixExp + stack.pop();
            // System.out.println("item poped " + stack.pop());
        }
        return postfixExp;
    }

}

