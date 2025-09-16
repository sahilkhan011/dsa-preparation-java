package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisValidatorWithPrecedence {
    private static final Map<Character,Character> closingToOpening = new HashMap<>();
    private static final Map<Character,Integer> precedence = new HashMap<>();

    static{
        closingToOpening.put('}','{');
        closingToOpening.put(']','[');
        closingToOpening.put(')','(');

        precedence.put('(',1);
        precedence.put('[',2);
        precedence.put('{',3);
    }

    public static void main(String[] args) {
        String[] tests = {
                "{[()]}",   // valid
                "{[(])}",   // invalid (mismatched close)
                "({[]})",   // invalid (higher precedence inside lower)
                "{[()]}()", // valid
                "((a+b))",  // strict: invalid, allow-equal: valid
                "[[ ]]"     // strict: invalid, allow-equal: valid
        };

        System.out.println("STRICT mode results:");
        for (String t : tests) {
            System.out.printf("%s -> %b%n", t, isParenthesisValid(t));
        }


    }

    private static boolean isParenthesisValid(String t) {
        Stack<Character> stack = new Stack<>();

        for(char c : t.toCharArray()){
            if(precedence.containsKey(c)){
                if (!stack.isEmpty()){
                    char peek = stack.peek();
                    // > --- equal nesting allow...
                    // >= equal nesting not allow...
                    if(precedence.get(c) >= precedence.get(peek)){
                        return false;
                    }
                }

                stack.push(c);
            }
            else if(closingToOpening.containsKey(c)){
                if(stack.isEmpty() || stack.pop() != closingToOpening.get(c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
