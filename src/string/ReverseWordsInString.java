package string;

import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String str = "Hello This is a String";
        System.out.println(str);
        String revStr = reverseWordsInStringSecond(str);
        System.out.println(revStr);  // Output: "String a is This Hello"
    }

    public static String reverseWordsInStringSecond(String str){
            StringBuilder ans = new StringBuilder();
            StringBuilder tempWord = new StringBuilder();

            for (char c : str.trim().toCharArray()) {
                if (c != ' ') {
                    tempWord.append(c);  // Build the current word
                } else {
                    if (!tempWord.isEmpty()) {  // Avoid appending extra spaces

                        ans.insert(0,tempWord);
                        if (!ans.isEmpty()) {  // Add a space only if it's not the first word
                            ans.insert(0," ");
                        }
                        tempWord = new StringBuilder();  // Reset tempWord for the next word
                    }
                }
            }

            // Append the last word if there's one
            if (!tempWord.isEmpty()) {
                ans.insert(0,tempWord);
            }

            return ans.toString();


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
