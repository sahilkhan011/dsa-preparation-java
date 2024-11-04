package string;

import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String str = "Hello This is a String";
        System.out.println(str);
        String revStr = reverseWordsInString(str);
        System.out.println(revStr);  // Output: "String a is This Hello"
    }

    private static String reverseWordsInString(String str) {
        Stack<String> revStack = getReverseStack(str);
        StringBuilder revStr = new StringBuilder();

        while (!revStack.isEmpty()) {
            revStr.append(revStack.pop());
            if (!revStack.isEmpty()) {
                revStr.append(" "); // Add space between words, but not after the last word
            }
        }
        return revStr.toString(); // Directly return the string
    }

    private static Stack<String> getReverseStack(String str) {
        Stack<String> revStack = new Stack<>(); // Specify the generic type
        StringBuilder tempWord = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (!tempWord.isEmpty()) { // Only push if there is a word
                    revStack.push(tempWord.toString());
                    tempWord.setLength(0); // Clear the StringBuilder
                }
            } else {
                tempWord.append(c); // Append character to the current word
            }
        }

        // Push the last word if exists
        if (!tempWord.isEmpty()) {
            revStack.push(tempWord.toString());
        }

        return revStack;
    }
}
