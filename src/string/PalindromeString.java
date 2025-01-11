package string;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // comment
        System.out.println(isPalindromeOptimalSolution(s)); // Output: true
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

    public static boolean isPalindromeOptimalSolution(String s) {
        if(s.isEmpty()) return true;
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            boolean isContinue = false;
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                isContinue = true;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                isContinue = true;
            }
            if (isContinue) continue;
            if(Character.toLowerCase(leftChar)!=Character.toLowerCase(rightChar)) return false;
            left++;
            right--;

        }
        return true;
    }
}
