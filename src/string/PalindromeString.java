package string;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // comment
        System.out.println(isPalindrome(s)); // Output: true
    }

    public static boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove all non-alphanumeric characters
        StringBuilder filteredString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredString.append(Character.toLowerCase(c));
            }
        }

        // Check if the filtered string is a palindrome
        String filtered = filteredString.toString();
        String reversed = filteredString.reverse().toString();

        return filtered.equals(reversed);
    }
}
