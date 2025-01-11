package string;

public class ReplaceAsciiInString {

    // Modify the string based on even and odd index rules
    public static String modifyString(String s) {
        StringBuilder ans = new StringBuilder();

        // Loop through each character of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If index is even, increase ASCII value by 1
            if (i % 2 == 0) {
                ans.append((char)(c + 1)); // Increment ASCII for even index
            }
            // If index is odd, decrease ASCII value by 1
            else {
                ans.append((char)(c - 1)); // Decrement ASCII for odd index
            }
        }

        // Return the modified string
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "abcdef";
        String ans = modifyString(str);
        // Print the result inside the main method
        System.out.println(ans);  // Output will be: "badcfe"
    }
}
