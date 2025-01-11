package string;

public class ReplaceAsciiInString {
    public static void modifyString(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If index is even, increase ASCII value by 1
            if (i % 2 == 0) {
                result.append((char)(c + 1));
            }
            // If index is odd, decrease ASCII value by 1
            else {
                result.append((char)(c - 1));
            }
        }

        // Print the result or do something else with it
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        String input = "abcdef";
        modifyString(input);  // Output will be: "badcfe"
    }

}
